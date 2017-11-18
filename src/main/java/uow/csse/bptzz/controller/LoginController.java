package uow.csse.bptzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uow.csse.bptzz.utils.FileUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
@RequestMapping("/lg")
public class LoginController {

    @GetMapping("/")
    public String uploadpage0() {
        return "/test_login";
    }


}
