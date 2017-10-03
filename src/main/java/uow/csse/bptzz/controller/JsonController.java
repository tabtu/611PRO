package uow.csse.bptzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uow.csse.bptzz.model.User;

import java.util.Date;

/**
 * Json Controller
 *
 * @author 	Tab Tu
 * @date	Oct.3 2017
 * @version	1.0
 */
@Controller
@RequestMapping("/json")
public class JsonController {

    @ResponseBody
    @RequestMapping("/user")
    public User get() {
        User user = new User();
        user.setId(1);
        user.setName("jayjay");
        user.setBirth(new Date());
        return user;
    }
}
