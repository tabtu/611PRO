package uow.csse.bptzz.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uow.csse.bptzz.model.User;

/**
 * Controller: Form Vaild. Used in Hibernate-validate
 *
 * @author 	Tab Tu
 * @date	Oct.3 2017
 * @version	1.0
 */
@Controller
@RequestMapping("/form")
public class FormController {

    @RequestMapping("/view")
    public String hello() {
        return "addUser";
    }

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public String add(@Valid User user, BindingResult br) {
        if(br.getErrorCount() > 0) {
            return "addUser";
        }
        return "showUser";
    }

    @RequestMapping(value="/add", method=RequestMethod.GET)
    public String add(Map<String, Object> map) {
        map.put("user", new User());
        return "addUser";
    }
}
