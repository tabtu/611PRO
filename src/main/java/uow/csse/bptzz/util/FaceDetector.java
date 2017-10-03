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


/**
 * Created by Tab Tu, Oct.2 2017
 * Updated by Tab Tu, Oct.2 2017
 * Des: test using OpenCV 3.2 jar package to detect faces on pictures.
 */
public class FaceDetector {

    public static void main(String[] args) {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("\nRunning FaceDetector");
        CascadeClassifier faceDetector = new CascadeClassifier("/Users/Kevin/Documents/Workspace/Java/611PRO/data/haarcascades/haarcascade_frontalface_alt.xml");
        System.out.println("1");

        Mat image = Imgcodecs.imread("/Users/Kevin/Documents/Workspace/Java/611PRO/0.JPEG");

        System.out.println("2");

        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);

        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));


        for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 255, 0));
        }

        String filename = "/Users/Kevin/Documents/Workspace/Java/611PRO/ouput.png";
        System.out.println(String.format("Writing %s", filename));
        Imgcodecs.imwrite(filename, image);


    }
}