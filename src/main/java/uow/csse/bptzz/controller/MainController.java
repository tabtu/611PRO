package uow.csse.bptzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import uow.csse.bptzz.config.Const;
import uow.csse.bptzz.model.User;
import uow.csse.bptzz.service.UserService;
import uow.csse.bptzz.utils.FileUtil;
import uow.csse.bptzz.utils.face.ImgCmp;
import uow.csse.bptzz.utils.face.ImgFace;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

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


    /**
     * check the similarity(youtu API)
     * POST http://localhost:8080/identify
     * @param username username in String
     * @param file capture picture after Base64 encode
     * @return the similarity
     */
    @RequestMapping(value = "/identify", method = RequestMethod.POST)
    public @ResponseBody String identify(@RequestParam("usr") String username,
                      @RequestParam("pic") MultipartFile file) {
        String profile = usrserv.findStudentByUsername(username).getProfilepic();
        try {
            File f1 = new File(Const.PROFILE_PATH + profile);
            double result = ImgCmp.compare(file.getBytes(), FileUtil.getContent(f1));
            return result + "";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * check the similarity(with opencv)
     * POST http://localhost:8080/cvidentify
     * @param username username in String
     * @param file capture picture after Base64 encode
     * @return the similarity
     */
    @RequestMapping(value = "/cvidentify", method = RequestMethod.POST)
    public @ResponseBody String cvidentify(@RequestParam("usr") String username,
                                         @RequestParam("pic") MultipartFile file) {
        System.out.println(username);
        try {
            ImgFace pic1 = new ImgFace(file.getBytes());
            System.out.println(pic1.getSourceEXT());
            int faces = pic1.dectface();
            if (faces > 0) {
                String profile = usrserv.findStudentByUsername(username).getProfilepic();
                System.out.println(profile);
                ImgFace pic0 = new ImgFace(Const.PROFILE_PATH + profile);
                double result = ImgCmp.compare(pic0.getImgbytes(), pic1.getImgbytes());
                return result + "";
            } else {
                return "nofaces";
            }
        } catch (Exception e) {

        }
        return "";
    }

    /**
     * upload file, named with timemillsecond string
     * http://localhost:8080/upload
     * @param file
     * @return message
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String uploadfile(@RequestParam("file") MultipartFile file) {
        String fileName = System.currentTimeMillis() + "." +
                FileUtil.getFileExtName(file.getOriginalFilename());
        String filePath = Const.UPLOAD_PATH;
        try {
            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "Upload Success";
    }

    /**
     * login service(POST)
     * @param model user model
     * @param error error text
     * @param logout logout mark
     * @return error message or page
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
        }
        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }
        return "home";
    }

    /**
     * login service(GET)
     * @param error error text
     * @param logout logout mark
     * @return error message or page
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView lg(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
        }
        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("/login");
        return model;

    }

    /**
     *
     * @return
     */
    @GetMapping("/register")
    public String getRegister() {
        return "/register";
    }

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String postRegister(HttpServletRequest request) {
        if (usrserv.findUserByUsernameOrEmail(request.getParameter("email"), request.getParameter("username")) != null) {
            return "Invalid Username or Email";
        }
        User usr = new User(request.getParameter("username"), request.getParameter("password"), request.getParameter("email"));
        usrserv.saveUser(usr);
        return "/login";
    }

    // customize the error message
    private String getErrorMessage(HttpServletRequest request, String key) {
        Exception exception = (Exception) request.getSession().getAttribute(key);
        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username and password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Invalid username and password!";
        }
        return error;
    }
}
