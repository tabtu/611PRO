package uow.csse.bptzz.demo;


import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;

public class CVTest {
    public static void main(String[] args) {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("\nRunning FaceDetector");
        CascadeClassifier faceDetector = new CascadeClassifier("~/Downloads/611PRO/611PRO/data/haarcascades/haarcascade_frontalface_alt.xml");
        //VideoCapture vc = new VideoCapture(0);
        //System.out.println("The camera is open: " + vc.isOpened());
        Mat image = Imgcodecs.imread("1.png");
        System.out.println(image.toString());
        System.out.println(image.height());
        Imgcodecs.imwrite("0.jpg", image);
    }
}