package uow.csse.bptzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import uow.csse.bptzz.model.Course;
import uow.csse.bptzz.service.CourseService;
import uow.csse.bptzz.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CourseController extends BaseController {
    @Autowired
    private CourseService coursev;

    @RequestMapping(value = "/course{course_id}", method = RequestMethod.GET)
    public ModelAndView getCourse(HttpServletRequest request) {
        String course_id = request.getParameter("course_id");
        Course course = coursev.findCourseById(course_id);

        ModelAndView mav = new ModelAndView("courses");
        mav.addObject("course", course);

        return "mav";
    }

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ModelAndView getCourses(HttpServletRequest request) {
        String username = request.getParameter("username");
        List<Course> courses = coursev.findCourseByUsername(username);

        ModelAndView mav = new ModelAndView("courses");
        mav.addObject("courses", courses);

        return "mav";
    }

}
