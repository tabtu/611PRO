package uow.csse.bptzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Tab Tu
 * @create 2017-10-03-04:20
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @RequestMapping(value = "/index" ,method= RequestMethod.POST)
    public ModelAndView userIndex(String username,String password){
        ModelAndView mav = new ModelAndView("user/success");
        if(!matchParams( username, password)){
            return new ModelAndView("/index");
        }
        mav.addObject("username",username);
        mav.addObject("password",password);
        return mav;
    }

    private boolean matchParams(String username,String password){
        if(isEmpty(username)||isEmpty(password))
            return false;
        else
            return true;
    }

    private boolean isEmpty(String s){
        if(s==null || "".equals(s))
            return true;
        else
            return false;
    }
}