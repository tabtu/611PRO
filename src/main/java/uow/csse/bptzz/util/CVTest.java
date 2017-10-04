package uow.csse.bptzz.util;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class CVTest {
    public static void main(String[] args) {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("\nRunning FaceDetector");
        CascadeClassifier faceDetector = new CascadeClassifier("/Users/Kevin/Documents/Workspace/Java/611PRO/data/haarcascades/haarcascade_frontalface_alt.xml");
        System.out.println("1");

        Mat image = Imgcodecs.imread("/Users/Kevin/Downloads/0.JPEG");
        Imgcodecs.imwrite("test.jpg", image);
    }
}
