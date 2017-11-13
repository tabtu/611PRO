package uow.csse.bptzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uow.csse.bptzz.config.Const;
import uow.csse.bptzz.model.User;
import uow.csse.bptzz.model.result.ExceptionMsg;
import uow.csse.bptzz.model.result.Response;
import uow.csse.bptzz.service.UserService;
import uow.csse.bptzz.utils.MD5Util;
import uow.csse.bptzz.utils.DateUtils;

//@Controller
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService usrserv;

    @GetMapping("/test")
    public void test() {
        User user = new User("test", "123", "i@tabtu.cn");
        usrserv.save(user);
    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public Response create(User user) {
        try {
            User registUser = usrserv.findByEmail(user.getEmail());
            if (null != registUser) {
                return result(ExceptionMsg.EmailUsed);
            }
            User userNameUser = usrserv.findByUsername(user.getUsername());
            if (null != userNameUser) {
                return result(ExceptionMsg.UserNameUsed);
            }
            user.setPassword(getPwd(user.getPassword()));
            user.setCreateTime(DateUtils.getCurrentTime());
            user.setLastModifyTime(DateUtils.getCurrentTime());
            user.setProfilePicture("");
            user.setValidataCode("");
            user.setIntroduction("");
            usrserv.save(user);
            getSession().setAttribute(Const.LOGIN_SESSION_KEY, user);
        } catch (Exception e) {
            logger.error("create user failed, ", e);
            return result(ExceptionMsg.FAILED);
        }
        return result();
    }

    protected String getPwd(String password){
        try {
            String pwd = MD5Util.encrypt(password + Const.PASSWORD_KEY);
            return pwd;
        } catch (Exception e) {
            logger.error("Encode Password Error：",e);
        }
        return null;
    }
}