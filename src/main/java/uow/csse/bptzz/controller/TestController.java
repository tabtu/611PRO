package uow.csse.bptzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import uow.csse.bptzz.config.Const;
import uow.csse.bptzz.model.*;
import uow.csse.bptzz.service.CourseService;
import uow.csse.bptzz.service.QuizService;
import uow.csse.bptzz.service.SecurityService;
import uow.csse.bptzz.service.UserService;
import uow.csse.bptzz.utils.FileUtil;
import uow.csse.bptzz.utils.MD5Util;
import uow.csse.bptzz.utils.face.ImgCmp;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * Use for testing
 *
 * @Author Tab Tu
 * @Update Nov.24 2017
 */

//@Controller
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    @Autowired
    private UserService usrserv;

    @Autowired
    private CourseService corsserv;

    @Autowired
    private QuizService quizserv;

    @Autowired
    private SecurityService secuserv;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
//    @Qualifier("org.springframework.security.authenticationManager")
    private AuthenticationManager authenticationManager;

    @GetMapping(value = "/tal")
    public String testal() {
//        String password = bCryptPasswordEncoder.encode("123456");
        secuserv.autologin("tabtu", "123456");
        return "/home";
    }

    @RequestMapping(value = "/autologin", method = RequestMethod.POST)
    public ModelAndView testautologin(HttpServletRequest request) {
        User tmp = usrserv.findUserByUsername("tabtu");
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(tmp.getUsername(), tmp.getPassword());
        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
        request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
        return new ModelAndView(new RedirectView("home"));
    }

    @RequestMapping(value = "/getstudent{username}", method = RequestMethod.GET)
    public Student getStudent(HttpServletRequest request) {
        String usnm = request.getParameter("username");
        return usrserv.findStudentByUsername(usnm);
    }

    @GetMapping("/getuser")
    public User getUser() {
        return usrserv.findUserByUsername("tabtu");
    }

    @GetMapping("/test")
    public void test() {
        User user = new User("test", "123", "i@tabtu.cn");
        usrserv.saveUser(user);
    }


    @GetMapping(value = "/testcmp")
    public String testcmp() {
//        String fn0 = usrserv.findStudentByUsername("tabtu").getProfilepic();
        String fn0 = Const.PROFILE_PATH + "tab.JPG";
        System.out.println(fn0);
        String fn1 = Const.UPLOAD_PATH + "1511075346694.jpg";
        System.out.println(fn1);

        File f0 = new File(fn0);
        File f1 = new File(fn1);

        try {
            double result = ImgCmp.compare(FileUtil.getContent(f0), FileUtil.getContent(f1));
            return result + "";
        } catch (Exception e) {
            return e.getMessage();
        }
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
    public List<Question> getquestion() {
        //return qustrepo.findByCourse(corpo.findOne("CS1002")).get(0).getContent();
        return quizserv.getTop10Questions("CS1002");
        //return qustrepo.findByCourse_Course_id("CS1002").size() + "";
        //return qustrepo.findByCourse_Day("FRIDAY").getTotalPages() + "";
    }

    @GetMapping("/initdepartment")
    public void initdepartment() {
        Department dept = new Department("Business");

        usrserv.saveDepartment(dept);
    }

    @GetMapping("/getstudent")
    public String getstudent() {

//        Student student = studrepo.findOne((long) 1);

        Student student = usrserv.findStudentByUsername("tabtu");
        System.out.println(student.getFirstname());

        return  student.getFirstname();
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