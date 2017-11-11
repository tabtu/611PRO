package uow.csse.bptzz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Const {
	
	public static String BASE_PATH;
	
	public static String LOGIN_SESSION_KEY = "bptzz_user";
	
	public static String PASSWORD_KEY = "*j2[#!&@HI@!(a5%t";
	public static String DES3_KEY = "1z9Iwf97FJs3hW8xcD0Pw4so";
	
	public static String default_logo="img/logo.jpg";
	
	public static String userAgent="Mozilla";
	
	public static String default_Profile=BASE_PATH+"/img/logo.jpg";
	
	public static String LAST_REFERER = "LAST_REFERER";

	public static int COOKIE_TIMEOUT= 30*24*60*60;

	@Autowired(required = true)
	public void setBasePath(@Value("${bptzz.base.path}")String basePath) { Const.BASE_PATH = basePath; }
}
