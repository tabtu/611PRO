package uow.csse.bptzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import uow.csse.bptzz.model.Course;
import uow.csse.bptzz.service.UserService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/course")
public class EasonController extends BaseController {
    @Autowired
    private CourseService coursev;

    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public Course GetCourse(HttpServletRequest request) {
        String course_id = request.getParameter("course_id");



        ModelAndView mav = new ModelAndView();
        mav.addObject()

        return "mav";
    }

}
