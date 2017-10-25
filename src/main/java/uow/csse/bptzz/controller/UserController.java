package uow.csse.bptzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uow.csse.bptzz.config.Const;
import uow.csse.bptzz.model.bptzz_Department;
import uow.csse.bptzz.model.bptzz_User;
import uow.csse.bptzz.repository.bptzz_DepartmentRepo;
import uow.csse.bptzz.repository.bptzz_UserRepo;
import uow.csse.bptzz.utils.DateUtils;
import uow.csse.bptzz.utils.MD5Util;

//@Controller
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private bptzz_UserRepo userRepository;

    @Autowired
    private bptzz_DepartmentRepo departmentRepository;

    @GetMapping("/test")
    public void test() {
        /*
        bptzz_User user = new bptzz_User();
        user.setUsername("username");
        user.setPassword("password");
        user.setEmail("e@mail.com");
        user.setCreateTime(DateUtils.getCurrentTime());
        user.setLastModifyTime(DateUtils.getCurrentTime());
        user.setProfilePicture("");
        user.setValidataCode("");
        user.setIntroduction("");
        userRepository.save(user);
        */

        bptzz_Department dp = new bptzz_Department();
        dp.setName("test");
        departmentRepository.save(dp);

    }

    /*
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public Response create(bptzz_User user) {
        try {
            bptzz_User registUser = userRepository.findByEmail(user.getEmail());
            if (null != registUser) {
                return result(ExceptionMsg.EmailUsed);
            }
            bptzz_User userNameUser = userRepository.findByUsername(user.getUsername());
            if (null != userNameUser) {
                return result(ExceptionMsg.UserNameUsed);
            }
            user.setPassword(getPwd(user.getPassword()));
            user.setCreateTime(DateUtils.getCurrentTime());
            user.setLastModifyTime(DateUtils.getCurrentTime());
            user.setProfilePicture("img/favicon.png");
            user.setValidataCode("");
            user.setIntroduction("");
            userRepository.save(user);
            getSession().setAttribute(Const.LOGIN_SESSION_KEY, user);
        } catch (Exception e) {
            // TODO: handle exception
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
            logger.error("密码加密异常：",e);
        }
        return null;
    }
    */
}