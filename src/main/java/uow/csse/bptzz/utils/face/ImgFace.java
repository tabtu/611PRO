//package uow.csse.bptzz.utils.face;
//
//import org.opencv.core.*;
//import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.imgproc.Imgproc;
//import org.opencv.objdetect.CascadeClassifier;
//
///**
// * OpenCV Operation
// * @Author Tab Tu
// * @Created Oct.21 2017
// * @Updated Nov.15 2017
// * @Description Include Detect Faces and So On.
// */
//public class ImgFace {
//
//    /**
//     * Front Face Training Data
//     */
//    public static String datafile = "src/main/resources/static/data/haarcascades/haarcascade_frontalface_alt.xml";
//    //private final static String IMG_PATH = Const.PFIMG_PATH;
//
//    private final static int WIDTH = 500;
//
//    private final static int HEIGHT = 500;
//
//    private Mat source;
//
//    private String sourceEXT;
//
//    public ImgFace(byte[] data) {
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        source =  Imgcodecs.imdecode(new MatOfByte(data), Imgcodecs.CV_LOAD_IMAGE_UNCHANGED);
//    }
//
//    public ImgFace(String sourcefilename) {
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        this.source = Imgcodecs.imread(sourcefilename);
//        this.sourceEXT = sourcefilename.substring(sourcefilename.length() - 4, sourcefilename.length());
//    }
//
//    /**
//     * Get Image File Extension Name
//     * @return
//     */
//    public String getSourceEXT() {
//        return this.sourceEXT;
//    }
//
//    public Mat getSource() {
//        return this.source;
//    }
//
//    /**
//     * Set the Mat frame with file
//     * @param filename path + filename
//     */
//    public void setSource(String filename) {
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        this.source = Imgcodecs.imread(filename);
//    }
//
//    /**
//     * get byte[] type of image
//     * @return
//     */
//    public byte[] getImgbytes() { return ImgUtils.Mat2Bytes(this.source, this.sourceEXT); }
//
//    /**
//     * Detect Faces in Image
//     * @return the number of faces
//     */
//    public int dectface() {
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        CascadeClassifier faceDetector = new CascadeClassifier(datafile);
//        MatOfRect faceDetections = new MatOfRect();
//        faceDetector.detectMultiScale(source, faceDetections);
//        Rect rec = new Rect();
//        if (faceDetections.toArray().length > 1) {
//            int gbestwidth = 0;
//            for (Rect rect : faceDetections.toArray()) {
//                if (rect.x > gbestwidth) { gbestwidth = rect.width; rec = rect; }
//            }
//        } else if(faceDetections.toArray().length == 1) {
//            rec = faceDetections.toArray()[0];
//        } else {
//            return 0;
//        }
//
//        // 扩大裁剪边界并修正。
//        if (rec.y > rec.height / 4) rec.y -= (rec.height / 4);
//        else rec.y = 0;
//        if (rec.x > rec.width / 4) rec.x -= (rec.width / 4);
//        else rec.x = 0;
//        if (rec.y + rec.height * 1.5 < source.height()) rec.height *= 1.5;
//        else rec.height = source.height() - rec.y;
//        if (rec.x + rec.width * 1.5 < source.width()) rec.width *= 1.5;
//        else rec.width = source.width() - rec.x;
//
//        // 裁剪图片并重新输出图片，大小定义为WIDTH*HEIGHT
//        Size size = new Size(WIDTH, HEIGHT);
//        Imgproc.resize(source.submat(rec), source, size);
//        return 1;
//    }
//}
