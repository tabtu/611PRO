package uow.csse.bptzz.demo;

import org.json.JSONObject;
import uow.csse.bptzz.utils.youtu.APIs;
import uow.csse.bptzz.utils.youtu.Func;

import java.io.File;

public class FaceCompare {
    public static void main(String[] args) {

        try {
            Func faceYoutu = new Func(APIs.APP_ID, APIs.SECRET_ID, APIs.SECRET_KEY, Func.API_YOUTU_END_POINT, APIs.USER_ID);
            JSONObject respose;
            //respose= faceYoutu.FaceCompareUrl("http://open.youtu.qq.com/content/img/slide-1.jpg","http://open.youtu.qq.com/content/img/slide-1.jpg");
            //respose = faceYoutu.DetectFace("FaceCompare.jpg",1);
            //respose = faceYoutu.FaceCompareUrl("https://tu6.myweb.cs.uwindsor.ca/img/1.JPG", "https://tu6.myweb.cs.uwindsor.ca/img/1.JPG");

            File img1 = new File("/Users/Kevin/Downloads/2.JPG");
            File img2 = new File("/Users/Kevin/Downloads/3.JPG");
            respose = faceYoutu.FaceCompare("21.png", "22.png");

            //String urla = "http://img5.imgtn.bdimg.com/it/u=2830684856,2570145019&fm=27&gp=0.jpg";
            //String urlb = "http://img5.imgtn.bdimg.com/it/u=2830684856,2570145019&fm=27&gp=0.jpg";
            //respose = faceYoutu.FaceCompareUrl(urla, urlb);
            //get respose
            System.out.println(respose);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
