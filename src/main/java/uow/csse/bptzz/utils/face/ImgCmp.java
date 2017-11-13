package uow.csse.bptzz.utils.face;

import org.json.JSONObject;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import uow.csse.bptzz.utils.youtu.APIs;
import uow.csse.bptzz.utils.youtu.Func;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ImgCmp {

    /**
     *
     * @return
     */
    public static double compare(byte[] source, byte[] target) {
        double result = 0;
        Func faceYoutu = new Func(APIs.APP_ID, APIs.SECRET_ID, APIs.SECRET_KEY, Func.API_YOUTU_END_POINT, APIs.USER_ID);
        try {
            JSONObject respose = faceYoutu.FaceCompare(source, target);
            result = (double) respose.get("similarity");
            System.out.println("test push file to tabtu branch");
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return result;
    }
}
