package uow.csse.bptzz.demo;

import org.opencv.core.Core;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.util.Base64Utils;
import uow.csse.bptzz.utils.FileUtil;
import uow.csse.bptzz.utils.face.ImgCmp;
import uow.csse.bptzz.utils.face.ImgFace;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class demo {
    private static String PROFILE_PATH = "src/main/resources/static/profile/";
    private static String UPLOAD_PATH = "src/main/resources/static/upload/";

    private static String[] faces = { "byp.png", "pzc.png", "ttxy.png", "zh.png", "zc.png" };
    private static String[] names = { "白云鹏", "潘志成", "涂螣霄尧", "周航", "张潮" };
    private final static int PROSIBILITY = 90;

    public static int login(String loginimage) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        double result;
        long total = 0;
        long start = System.currentTimeMillis();
        ImgFace fd = new ImgFace(loginimage);
        if (fd.dectface() != 1) {
            return -1;
        }
        Imgcodecs.imwrite("profile/logintest" + fd.getSourceEXT(), fd.getSource());
        total += System.currentTimeMillis() - start;
        System.out.println("search face: " + total);

        for (int i = 0; i < faces.length; i++) {
            start = System.currentTimeMillis();
            ImgFace fd0 = new ImgFace("profile/" + faces[i]);
            System.out.println(faces[i]);
            result = ImgCmp.compare(fd.getImgbytes(), fd0.getImgbytes());
            long tmp = System.currentTimeMillis() - start;
            total += tmp;
            System.out.println(result + " ---> " + tmp);
            if (result > PROSIBILITY) {
                System.out.println("total: " + total);
                return i;
            }
        }
        System.out.println("total: " + total);
        return -2;
    }

    /**
     *
     * @param files
     */
    public static void gethead(String[] files) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        for (String e : files) {
            ImgFace i = new ImgFace(UPLOAD_PATH + e);
            i.dectface();
            Imgcodecs.imwrite(UPLOAD_PATH + System.currentTimeMillis() + e, i.getSource());
        }
    }

    public static void testcmp() {
        ImgFace a0 = new ImgFace(PROFILE_PATH + "5.JPG");
        a0.dectface();
        ImgFace a1 = new ImgFace(PROFILE_PATH + "TTXY.JPG");
        double result = ImgCmp.compare(a0.getImgbytes(), a1.getImgbytes());
        System.out.println(result);
    }

    public static void testbytebase64() {
        ImgFace a = new ImgFace(PROFILE_PATH + "00.JPG");
        byte[] b = a.getImgbytes();
        String s0 = Base64Utils.encodeToString(b);
        //String s0 = Base64Util.encode(b);
        File f0 = new File(UPLOAD_PATH + "00.txt");
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(f0));
            out.flush();
            out.write(s0);
            out.close();
        } catch(Exception e) {

        }
    }

    public static void testcmpfromfile() {
        try {
            File f0 = new File(PROFILE_PATH + "TTXY.JPG");
            File f1 = new File(PROFILE_PATH + "tab.JPG");
            double result = ImgCmp.compare(FileUtil.getContent(f0), FileUtil.getContent(f1));
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] sname = { "1.JPG"};//, "2.JPG", "3.JPG", "4.JPG", "5.JPG" };
        gethead(sname);
//        testcmp();
//        testbytebase64();
//        testcmpfromfile();
//        int who = login(Const.UPLOAD_PATH + "1511030426997.jpg");
//        if (who >= 0) System.out.println(names[who]);
//        else System.out.println("unknown");
    }
}
