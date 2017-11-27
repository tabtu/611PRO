package uow.csse.bptzz.controller;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import uow.csse.bptzz.config.Const;
import uow.csse.bptzz.model.User;
import uow.csse.bptzz.service.SecurityService;
import uow.csse.bptzz.service.UserService;
import uow.csse.bptzz.utils.FileUtil;
import uow.csse.bptzz.utils.face.ImgCmp;
import uow.csse.bptzz.utils.face.ImgFace;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;

/**
 * Login Controller
 *
 * @author 	Tab Tu
 * @update	Nov.21 2017
 * @version	1.2
 */

@Controller
public class LoginController {

    @Autowired
    private SecurityService secuserv;

    @Autowired
    private UserService userserv;


    @RequestMapping(value = "/auto{user}", method = RequestMethod.GET)
    public String atlg(HttpServletRequest request) {
        String username = request.getParameter("user");
        secuserv.autologin(username, "123456");
        return "/home";
    }
    /**
     * check the similarity(youtu API)
     * POST http://localhost:8080/identify
     * @param username username in String
     * @param basedata capture picture after Base64 encode
     * @return the similarity
     */
    @RequestMapping(value = "/identify", method = RequestMethod.POST)
    @ResponseBody
    public String identify(@RequestParam("usr") String username,
                           @RequestParam("data") String basedata) {
        try {
            String profile = userserv.findUserByUsername(username).getStudent().getProfilepic();
            byte[] k = Base64Utils.decodeFromString(basedata.substring("data:image/jpeg;base64,".length()));
            File f1 = new File(Const.PROFILE_PATH + profile);
            double result = ImgCmp.compare(k, FileUtil.getContent(f1));
            return result + "";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * check the similarity and auto login with username(youtu API)
     * POST http://localhost:8080/autologin
     * @param username username in String
     * @param basedata capture picture after Base64 encode
     * @return the similarity
     */
    @RequestMapping(value = "/autologin", method = RequestMethod.POST)
    @ResponseBody
    public String autologin(@RequestParam("usr") String username,
                           @RequestParam("data") String basedata) {

        try {
            String profile = userserv.findUserByUsername(username).getStudent().getProfilepic();
            byte[] k = Base64Utils.decodeFromString(basedata.substring("data:image/jpeg;base64,".length()));
            File f1 = new File(Const.PROFILE_PATH + profile);
            double result = ImgCmp.compare(k, FileUtil.getContent(f1));
            if (result > 90) {
                System.out.println(username);
                secuserv.autologin(username, "123456");
            }
            return result + "";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * upload image with base64 string
     * @param data image data base64 code
     * @return filename
     */
    @RequestMapping(value = { "/base64upload" }, method = { RequestMethod.POST })
    @ResponseBody
    public String petUpgradeTarget(String data) {
        try {
            byte[] k = Base64Utils.decodeFromString(data.substring("data:image/jpeg;base64,".length()));
            String fileName = UUID.randomUUID().toString() + ".jpeg";
            String filePath = Const.UPLOAD_PATH;
            FileUtil.uploadFile(k, filePath, fileName);
            return fileName;
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * compare the similarity between two person
     * @param f1 first file
     * @param f2 second file
     * @return the similarity
     */
    @RequestMapping(value = "/compare", method = RequestMethod.POST)
    @ResponseBody
    public String whoami(@RequestParam("pic1") MultipartFile f1,
                         @RequestParam("pic2") MultipartFile f2) {
        try {
            double result = ImgCmp.compare(f1.getBytes(), f2.getBytes());
            return result + "";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * check the similarity(youtu API)
     * POST http://localhost:8080/whoami
     * @param username username in String
     * @param file picture file
     * @return the similarity
     */
    @RequestMapping(value = "/whoami", method = RequestMethod.POST)
    @ResponseBody
    public String whoami(@RequestParam("usr") String username,
                         @RequestParam("pic") MultipartFile file) {
        String profile = userserv.findUserByUsername(username).getStudent().getProfilepic();
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
     * POST http://localhost:8080/cvwhoami
     * @param username username in String
     * @param file picture file
     * @return the similarity
     */
    @RequestMapping(value = "/cvwhoami", method = RequestMethod.POST)
    @ResponseBody
    public String cvwhoami(@RequestParam("usr") String username,
                           @RequestParam("pic") MultipartFile file) {
        try {
            ImgFace pic1 = new ImgFace(file.getBytes());
            int faces = pic1.dectface();
            if (faces > 0) {
                String profile = userserv.findUserByUsername(username).getStudent().getProfilepic();
                ImgFace pic0 = new ImgFace(Const.PROFILE_PATH + profile);
                return ImgCmp.compare(pic0.getImgbytes(), pic1.getImgbytes()) + "";
            } else {
                return "nofaces";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * upload file, named with timemillsecond string
     * http://localhost:8080/upload
     * @param file
     * @return message
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadfile(@RequestParam("file") MultipartFile file) {
        String fileName = UUID.randomUUID().toString() + "." +
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
        if (userserv.findUserByUsernameOrEmail(request.getParameter("email"), request.getParameter("username")) != null) {
            return "Invalid Username or Email";
        }
        User usr = new User(request.getParameter("username"), request.getParameter("password"), request.getParameter("email"));
        userserv.saveUser(usr);
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
