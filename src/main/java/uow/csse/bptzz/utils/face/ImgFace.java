package uow.csse.bptzz.utils.face;

import org.json.JSONObject;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import uow.csse.bptzz.config.Const;
import uow.csse.bptzz.utils.youtu.APIs;
import uow.csse.bptzz.utils.youtu.Func;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ImgFace {

    /**
     * Front Face Training Data
     */
    //private final static String datafile = Const.DATA_PATH + "haarcascades/haarcascade_frontalface_alt.xml";
    public static String datafile = "src/main/resources/static/data/haarcascades/haarcascade_frontalface_alt.xml";

    //private final static String IMG_PATH = Const.PFIMG_PATH;

    private final static int WIDTH = 300;

    private final static int HEIGHT = 300;

    private Mat source;

    private String sourceEXT;

    private Mat target;

    private String targetEXT;

    public ImgFace() {

    }

    public ImgFace(String sourcefilename, String targetfilename) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        this.source = Imgcodecs.imread(sourcefilename);
        sourceEXT = sourcefilename.substring(sourcefilename.length() - 4, sourcefilename.length());
        this.target = Imgcodecs.imread(targetfilename);
        this.targetEXT = targetfilename.substring(targetfilename.length() - 4, targetfilename.length());
    }

    public String getSourceEXT() {
        return this.sourceEXT;
    }

    public String getTargetEXT() {
        return this.targetEXT;
    }

    public Mat getSource() {
        return this.source;
    }

    public Mat getTarget() {
        return this.target;
    }

    public void setSource(String filename) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        this.source = Imgcodecs.imread(filename);
    }

    public void setTarget(String filename) {
        this.target = detectFace(filename);
    }

    public byte[] getSource2bytes() {
        return ImgUtils.Mat2Bytes(this.source, this.sourceEXT);
    }

    public byte[] getTarget2bytes() {
        return ImgUtils.Mat2Bytes(this.target, this.targetEXT);
    }

    /**
     * 检测图片并裁剪到WIDTH*HEIGHT
     * @param filename
     * @return
     */
    private Mat detectFace(String filename) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        CascadeClassifier faceDetector = new CascadeClassifier(datafile);
        MatOfRect faceDetections = new MatOfRect();
        Mat img = Imgcodecs.imread(filename);
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
        Size size = new Size(WIDTH, HEIGHT);
        Mat dst = new Mat();
        Imgproc.resize(img.submat(rec), dst, size);
        return dst;
    }
}
