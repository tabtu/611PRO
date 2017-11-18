package uow.csse.bptzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import uow.csse.bptzz.config.Const;
import uow.csse.bptzz.model.Course;
import uow.csse.bptzz.model.Department;
import uow.csse.bptzz.model.Question;
import uow.csse.bptzz.model.User;
import uow.csse.bptzz.model.result.ExceptionMsg;
import uow.csse.bptzz.model.result.Response;
import uow.csse.bptzz.repository.*;
import uow.csse.bptzz.service.CourseService;
import uow.csse.bptzz.service.QuizService;
import uow.csse.bptzz.service.UserService;
import uow.csse.bptzz.utils.MD5Util;
import uow.csse.bptzz.utils.DateUtils;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService usrserv;

    @Autowired
    private CourseService corsserv;

    @Autowired
    private QuizService quizserv;

    @Autowired
    private QuestionRepo qustrepo;

    @Autowired
    private CourseRepo corpo;

    @Autowired
    private DepartmentRepo deptrepo;

    @Autowired
    private UserRepo usrpo;

    @Autowired
    private StudentRepo studrepo;

    @GetMapping("/getuser")
    public User getUser() {
        return usrserv.findUserByUsername("tabtu");
    }

    @GetMapping("/test")
    public void test() {
        User user = new User("test", "123", "i@tabtu.cn");
        usrserv.saveUser(user);
    }

    @GetMapping("/tt")
    public String dptcors() {
        List<Course> ss = corsserv.findCoursesByUsername("tabtu");
//        return studrepo.findOne(1).getS_department().getName();
        //return corsserv.findCourseByDepartmentId(1).size() + "";
        //return qustrepo.findByCourse(corpo.findOne("CS1002")).size() + "";
        return ss.get(0).getCourseName();
    }

    @GetMapping("/getquestions")
    public String getquestion() {
        //return qustrepo.findByCourse(corpo.findOne("CS1002")).get(0).getContent();
        return quizserv.get10RandomQuestions("CS1002")[0].getContent();
        //return qustrepo.findByCourse_Course_id("CS1002").size() + "";
        //return qustrepo.findByCourse_Day("FRIDAY").getTotalPages() + "";
    }

    @GetMapping("/initdepartment")
    public void initdepartment() {
        Department dept = new Department("Business");

        usrserv.saveDepartment(dept);
    }

    protected String getPwd(String password){
        try {
            String pwd = MD5Util.encrypt(password + Const.PASSWORD_KEY);
            return pwd;
        } catch (Exception e) {
            logger.error("Encode Password Error：",e);
        }
        return null;
    }
}