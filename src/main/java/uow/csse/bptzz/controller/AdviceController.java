package uow.csse.bptzz.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 控制器: 处理全局异常(所有Controller)
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

