package uow.csse.bptzz.utils.face;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ImgUtils {
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
}
