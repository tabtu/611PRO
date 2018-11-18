package uow.csse.bptzz.utils.face;

import org.json.JSONObject;
import uow.csse.bptzz.utils.youtu.APIs;
import uow.csse.bptzz.utils.youtu.Func;

/**
 * Compare Images
 * @Author Tab Tu
 * @Created Oct.27 2017
 * @Updated Nov.15 2017
 * @Description Include Detect Faces and So On.
 */
public class ImgCmp {

    /**
     * Youtu face API
     * @return the similarity fo these two pictures.
     */
    public static double compare(byte[] source, byte[] target) {
        double result = 0;
        Func faceYoutu = new Func(APIs.APP_ID, APIs.SECRET_ID, APIs.SECRET_KEY, Func.API_YOUTU_END_POINT, APIs.USER_ID);
        try {
            JSONObject respose = faceYoutu.FaceCompare(source, target);
            result = (double) respose.get("similarity");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
        return result;
    }
}
