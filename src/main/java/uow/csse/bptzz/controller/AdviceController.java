package uow.csse.bptzz.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handle All Exception (Root Controller)
 *
 * @author 	Tab Tu
 * @date	2016年5月17日
 * @since	1.0
 */
@ControllerAdvice
public class AdviceController {

    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception ex) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", ex);
        System.out.println("in AdviceController");
        return mv;
    }
}

