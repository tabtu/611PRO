package uow.csse.bptzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Main Controller
 *
 * @author 	Tab Tu
 * @date	Oct.17 2017
 * @version	1.0
 */

@Controller
public class MainController {

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

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "home";
    }

    @GetMapping("/game")
    public String game() { return "/demo/game"; }

    @GetMapping("/capture")
    public String capture() { return "/demo/capture"; }

    @GetMapping("/firework")
    public String firework() { return "/demo/firework"; }

    @GetMapping("/regist")
    public String showregist() {
        return "/register";
    }
}
