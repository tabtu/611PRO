package uow.csse.bptzz.controller;

import uow.csse.bptzz.config.Const;
import uow.csse.bptzz.model.bptzz_User;
import uow.csse.bptzz.model.result.ExceptionMsg;
import uow.csse.bptzz.model.result.Response;
import uow.csse.bptzz.utils.Des3EncryptionUtil;
import uow.csse.bptzz.utils.MD5Util;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BaseController {

    protected Logger logger = Logger.getLogger(this.getClass());

    protected Response result(ExceptionMsg msg){
    	return new Response(msg);
    }
    protected Response result(){
    	return new Response();
    }

    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
    
    protected HttpSession getSession() {
        return getRequest().getSession();
    }
    
    protected bptzz_User getUser() {
        return (bptzz_User) getSession().getAttribute(Const.LOGIN_SESSION_KEY);
    }
    
    protected Long getUserId() {
    	Long id=0l;
        bptzz_User user=getUser();
    	if(user!=null){
    		id=user.getId();
    	}
        return id;
    }
    
    protected String getUserName() {
    	String userName="BPTZZ";
        bptzz_User user=getUser();
    	if(user!=null){
    		userName=user.getUsername();
    	}
        return userName;
    }
    
    protected String getUserIp() {
        String value = getRequest().getHeader("X-Real-IP");
        if (StringUtils.isNotBlank(value) && !"unknown".equalsIgnoreCase(value)) {
            return value;
        } else {
            return getRequest().getRemoteAddr();
        }
    }
    
    protected String getPwd(String password){
    	try {
    		String pwd = MD5Util.encrypt(password + Const.PASSWORD_KEY);
    		return pwd;
		} catch (Exception e) {
			logger.error("Encoding Error：",e);
		}
    	return null;
    }

    protected String cookieSign(String value){
        try{
            value = value + Const.PASSWORD_KEY;
            String sign = Des3EncryptionUtil.encode(Const.DES3_KEY,value);
            return sign;
        }catch (Exception e){
            logger.error("cookie Auth error：",e);
        }
        return null;
    }
}
