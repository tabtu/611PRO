package uow.csse.bptzz.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handle Exception in Controller.
 *
 * @author 	Tab Tu
 * @date	Oct.3 2017
 * @version	1.0
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController {

    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception ex) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", ex);
        System.out.println("in testExceptionHandler");
        return mv;
    }

    @RequestMapping("/error")
    public String error() {
        int i = 5 / 0;
        // just for clear warning of unused
        i = i + 1;
        return "hello";
    }
}
