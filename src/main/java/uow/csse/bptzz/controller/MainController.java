package uow.csse.bptzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Main Controller
 *
 * @author 	Tab Tu
 * @date	Oct.17 2017
 * @version	1.0
 */
@Controller
@RequestMapping
public class MainController {

    @RequestMapping("/m")
    public String game() {
        return "game";
    }

    @RequestMapping("/")
    public String index() {
        return "login";
    }

    @RequestMapping("/h")
    public String capture() {
        return "h5capture";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

}