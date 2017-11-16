package uow.csse.bptzz.utils.face;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

/**
 * OpenCV Operation
 * @Author Tab Tu
 * @Created Oct.21 2017
 * @Updated Nov.15 2017
 * @Description Include Detect Faces and So On.
 */
public class ImgFace {

    /**
     * Front Face Training Data
     */
    public static String datafile = "src/main/resources/static/data/haarcascades/haarcascade_frontalface_alt.xml";
    //private final static String IMG_PATH = Const.PFIMG_PATH;

    private final static int WIDTH = 300;

    private final static int HEIGHT = 300;

    private Mat source;

    private String sourceEXT;

    public ImgFace(String sourcefilename) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        this.source = Imgcodecs.imread(sourcefilename);
        this.sourceEXT = sourcefilename.substring(sourcefilename.length() - 4, sourcefilename.length());
    }

    /**
     * Get Image File Extension Name
     * @return
     */
    public String getSourceEXT() {
        return this.sourceEXT;
    }

    public Mat getSource() {
        return this.source;
    }

    /**
     * Set the Mat frame with file
     * @param filename path + filename
     */
    public void setSource(String filename) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        this.source = Imgcodecs.imread(filename);
    }

    /**
     * get byte[] type of image
     * @return
     */
    public byte[] getImgbytes() { return ImgUtils.Mat2Bytes(this.source, this.sourceEXT); }

    /**
     * Detect Faces in Image
     * @return the number of faces
     */
    public int dectface() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        CascadeClassifier faceDetector = new CascadeClassifier(datafile);
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(source, faceDetections);
        Rect rec = new Rect();
        if (faceDetections.toArray().length > 1) {
            int gbestwidth = 0;
            for (Rect rect : faceDetections.toArray()) {
                if (rect.x > gbestwidth) { gbestwidth = rect.width; rec = rect; }
            }
        } else if(faceDetections.toArray().length == 1) {
            rec = faceDetections.toArray()[0];
        } else {
            return 0;
        }
        Size size = new Size(WIDTH, HEIGHT);
        Imgproc.resize(source.submat(rec), source, size);
        return 1;
    }
}
