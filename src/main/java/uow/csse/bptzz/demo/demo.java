package uow.csse.bptzz.demo;

import org.opencv.core.Core;
import org.opencv.imgcodecs.Imgcodecs;
import uow.csse.bptzz.utils.face.ImgCmp;
import uow.csse.bptzz.utils.face.ImgFace;

public class demo {
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

    public static void main(String[] args) {
        int who = login("profile/1.JPG");
        if (who >= 0) System.out.println(names[who]);
        else System.out.println("unknown");
    }
}
