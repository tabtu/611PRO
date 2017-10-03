package uow.csse.bptzz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Testing MVC Framework
 *
 * @author 	Tab Tu
 * @date	Oct.3 2017
 * @version	1.0
 */
@RestController
public class HelloWorld {

    @RequestMapping("/a")
    public String index() {
        return "Index Page";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping("/myapp")
    public String myapp() {
        return "myapp";
    }
}