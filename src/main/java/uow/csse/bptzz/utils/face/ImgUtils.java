//package uow.csse.bptzz.utils.face;
//
//import org.opencv.core.Core;
//import org.opencv.core.Mat;
//import org.opencv.core.MatOfByte;
//import org.opencv.imgcodecs.Imgcodecs;
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.awt.image.DataBufferByte;
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//
///**
// * Image Type Transfer
// * @Author Tab Tu
// * @Created Oct.13 2017
// * @Updated Nov.15 2017
// * @Description Mat, byte[], BufferedImage
// */
//public class ImgUtils {
//    /**
//     *
//     * @param img Mat format image
//     * @param fileExtension file extension(.JPG & .PNG)
//     * @return
//     */
//    public static byte[] Mat2Bytes(Mat img, String fileExtension) {
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        MatOfByte mob = new MatOfByte();
//        Imgcodecs.imencode(fileExtension, img, mob);
//        return mob.toArray();
//    }
//
//    /**
//     * Transfer BufferedImage to Mat
//     * @param bfImg
//     * @param imgType bufferedImage. eg: BufferedImage.TYPE_3BYTE_BGR
//     * @param matType Mat. eg: CvType.CV_8UC3
//     * @return
//     */
//    public static Mat BuffedImage2Mat(BufferedImage bfImg, int imgType, int matType) {
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        if (bfImg == null) { throw new IllegalArgumentException("original == null"); }
//        if (bfImg.getType() != imgType) {
//            BufferedImage image = new BufferedImage(bfImg.getWidth(), bfImg.getHeight(), imgType);
//            Graphics2D g = image.createGraphics();
//            try {
//                g.setComposite(AlphaComposite.Src);
//                g.drawImage(bfImg, 0, 0, null);
//            } finally {
//                g.dispose();
//            }
//        }
//        byte[] pixels = ((DataBufferByte) bfImg.getRaster().getDataBuffer()).getData();
//        Mat mat = Mat.eye(bfImg.getHeight(), bfImg.getWidth(), matType);
//        mat.put(0, 0, pixels);
//        return mat;
//    }
//
//    /**
//     *
//     * @param img Mat Object
//     * @param fileExtension file extension name (.JPG & .PNG)
//     * @return
//     */
//    public static BufferedImage Mat2BuffedImage(Mat img, String fileExtension) {
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        MatOfByte mob = new MatOfByte();
//        Imgcodecs.imencode(fileExtension, img, mob);
//        byte[] byteArray = mob.toArray();
//        BufferedImage bufImage = null;
//        try {
//            InputStream in = new ByteArrayInputStream(byteArray);
//            bufImage = ImageIO.read(in);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return bufImage;
//    }
//}
