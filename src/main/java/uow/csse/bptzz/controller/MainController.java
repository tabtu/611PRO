package uow.csse.bptzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import uow.csse.bptzz.service.UserService;

/**
 * Main Controller
 *
 * @author 	Tab Tu
 * @update	Nov.20 2017
 * @version	1.2
 */

@Controller
public class MainController {

    @Autowired
    private UserService usrserv;

    @GetMapping("/")
    public String home0() {
        return "/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }

    @GetMapping("/upload")
    public String uploadpage() {
        return "/test";
    }

    @GetMapping("/demo")
    public String demo() {
        return "/demo/capture";
    }
}
