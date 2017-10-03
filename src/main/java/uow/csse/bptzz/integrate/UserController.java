package uow.csse.bptzz.integrate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import uow.csse.bptzz.model.User;

/**
 * User Controller
 *
 * @author 	Lian
 * @date	2016年5月18日
 * @since	1.0
 */
@Controller
@RequestMapping("/integrate")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public String saveUser(@RequestBody @ModelAttribute User user) {
        System.out.println(user);
        userService.save();
        return "hello";
    }
}