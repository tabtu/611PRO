package uow.csse.bptzz.utils.face;

import org.json.JSONObject;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import uow.csse.bptzz.utils.youtu.APIs;
import uow.csse.bptzz.utils.youtu.Func;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class FaceDetector {

    public static String datafile = "src/main/resources/static/data/haarcascades/haarcascade_frontalface_alt.xml";

    /**
     * Front Face Training Data
     */
    //private static String datafile = Const.DATA_PATH + "haarcascades/haarcascade_frontalface_alt.xml";

    /**
     *
     * @param img
     * @return
     */
    public static Mat DetectFace(Mat img) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        CascadeClassifier faceDetector = new CascadeClassifier(datafile);
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(img, faceDetections);
        Rect rec = new Rect();
        if (faceDetections.toArray().length > 1) {
            int gbestwidth = 0;
            for (Rect rect : faceDetections.toArray()) {
                if (rect.x > gbestwidth) { gbestwidth = rect.width; rec = rect; }
            }
        } else if(faceDetections.toArray().length == 1) {
            rec = faceDetections.toArray()[0];
        } else {
            return null;
        }
        Size size = new Size(300, 300);
        Mat dst = new Mat();
        Imgproc.resize(img.submat(rec), dst, size);
        return dst;
    }

    /**
     *
     * @param img
     * @param fileExtension (.JPG & .PNG)
     * @return
     */
    public static byte[] Mat2Bytes(Mat img, String fileExtension) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        MatOfByte mob = new MatOfByte();
        Imgcodecs.imencode(fileExtension, img, mob);
        return mob.toArray();
    }

    /**
     * 将BufferedImage类型转换成Mat类型
     * @param bfImg
     * @param imgType bufferedImage的类型 如 BufferedImage.TYPE_3BYTE_BGR
     * @param matType 转换成mat的type 如 CvType.CV_8UC3
     * @return
     */
    public static Mat BuffedImage2Mat(BufferedImage bfImg, int imgType, int matType) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        if (bfImg == null) { throw new IllegalArgumentException("original == null"); }
        if (bfImg.getType() != imgType) {
            BufferedImage image = new BufferedImage(bfImg.getWidth(), bfImg.getHeight(), imgType);
            Graphics2D g = image.createGraphics();
            try {
                g.setComposite(AlphaComposite.Src);
                g.drawImage(bfImg, 0, 0, null);
            } finally {
                g.dispose();
            }
        }
        byte[] pixels = ((DataBufferByte) bfImg.getRaster().getDataBuffer()).getData();
        Mat mat = Mat.eye(bfImg.getHeight(), bfImg.getWidth(), matType);
        mat.put(0, 0, pixels);
        return mat;
    }

    /**
     *
     * @param img Mat对象
     * @param fileExtension 文件扩展名(.JPG & .PNG)
     * @return
     */
    public static BufferedImage Mat2BuffedImage(Mat img, String fileExtension) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        MatOfByte mob = new MatOfByte();
        Imgcodecs.imencode(fileExtension, img, mob);
        byte[] byteArray = mob.toArray();
        BufferedImage bufImage = null;
        try {
            InputStream in = new ByteArrayInputStream(byteArray);
            bufImage = ImageIO.read(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bufImage;
    }

    public static void demo(String f1, String f1ext, String f2, String f2ext) {
        System.out.println(datafile);
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        long start = System.currentTimeMillis();
        Mat d1 = DetectFace(Imgcodecs.imread(f1));
        Mat d2 = DetectFace(Imgcodecs.imread(f2));
        byte[] s1 = Mat2Bytes(d1, f1ext);
        byte[] s2 = Mat2Bytes(d2, f2ext);
        long mid = System.currentTimeMillis();
        double re = ImgCmp.compare(s1, s2);
        System.out.println(re);
        /*
        Func faceYoutu = new Func(APIs.APP_ID, APIs.SECRET_ID, APIs.SECRET_KEY, Func.API_YOUTU_END_POINT, APIs.USER_ID);
        try {
            JSONObject respose = faceYoutu.FaceCompare(s1, s2);
            System.out.println("对比" + f1 + f1ext + " 和" + f2 + f2ext + ", 相似度为: " + respose.get("similarity") + "%");
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
        long end = System.currentTimeMillis();

        System.out.println("检测2次人脸图片耗时: " + (mid - start) + "ms; 完成对比耗时: " + (end - mid) + "ms");
    }

    public static void main(String[] args) {
//        demo("profile/3.JPG", ".JPG", "profile/zh.PNG", ".PNG");

        ImgFace fc = new ImgFace();
        fc.setSource("profile/ttxy.png");
        fc.setTarget("profile/1.JPG");

        System.out.println("1");

        double re = ImgCmp.compare(fc.getSource2bytes(), fc.getTarget2bytes());
        System.out.println(re);
    }
}
