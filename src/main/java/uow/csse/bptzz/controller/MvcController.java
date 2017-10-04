package uow.csse.bptzz.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import uow.csse.bptzz.model.Person;

/**
 * Mvc Controller
 * Examples about using each method to achieve functions.
 *
 * @author 	Tab Tu
 * @date	Oct.3 2017
 * @version	1.0
 */
@Controller
@RequestMapping("/mvc")
public class MvcController {

    /**
     * Test Function. HelloWorld
     *
     * @url: http://localhost:8080/mvc/hello
     *
     * @return String hello
     */
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    /**
     * match automatically
     * @url: http://localhost:8080/mvc/person?name=Tab&age=20
     *
     * @param name
     * @param age
     * @return
     */
    @RequestMapping("/person")
    public String toPerson(String name, double age) {
        System.out.println(name + " " + age);
        return "hello";
    }

    /**
     * boxing automatically
     * @url:    http://localhost:8080/mvc/person1?name=tab&age=20
     * 		    http://localhost:8080/mvc/person1?name=ab&age=20.0
     * @attention: It will not box automatically when params do not match.
     *
     * @param p
     * @return
     */
    @RequestMapping("/person1")
    public String toPerson(Person p) {
        System.out.println(p.getName() + " " + p.getAge());
        return "hello";
    }

    /**
     * the parameter was coverted in initBinder
     * @url:	http://localhost:8080/mvc/date?date=2017-10-04
     * 		    http://localhost:8080/mvc/date?date=2017-10
     * 		    http://localhost:8080/mvc/date?date=2017-10-04 15:00:00
     *
     * @param date
     * @return
     */
    @RequestMapping("/date")
    public String date(Date date) {
        System.out.println(date);
        return "hello";
    }

    /**
     * At the time of initialization, convert the type "String" to type "date"
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        System.out.println("InitBinder of date : convert the type of String to type date.");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    /**
     * pass the parameters to front-end
     * Front-End can get 'p' from Request. Using HttpServletRequest.setAttribute() can send message to Front-End also.
     * 前台可在Request域中取到"p", 另外, 使用HttpServletRequest.setAttribute()方法也可以实现向前台传递参数
     * @url:	http://localhost:8080/mvc/show
     * @param map
     * @return
     */
    @RequestMapping("/show")
    public void showPerson(Model model) {
        Person p = new Person();
        p.setAge(20);
        p.setName("Tab");
        model.addAttribute("p", p);
    }

    /**
     * pass the parameters to front-en using ajax
     * url:	http://localhost:8080/mvc/page/ajax
     *
     * @param name
     * @param pw
     */
    @RequestMapping(value = "/getPerson", method = RequestMethod.POST)
    public void getPerson(String name, PrintWriter pw) {
        // HttpServletResponse.getWriter()  // to get PrintWriter
        pw.write("hello, " + name);
    }

    /**
     * use redirect to deal request
     * @url:	http://localhost:8080/mvc/redirect
     *
     * @return
     */
    @RequestMapping("/redirect")
    public String redirect() {
        return "redirect:hello";
    }

    /**
     * upload file
     * @url	http://localhost:8080/mvc/page/upload
     * TODO	file will be uploaded into folder /upload
     *
     * @param request
     * @throws IOException
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void upload(HttpServletRequest request) throws IOException {
        MultipartHttpServletRequest mreq = (MultipartHttpServletRequest) request;
        MultipartFile file = mreq.getFile("file");
        String fileName = file.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        FileOutputStream fos = new FileOutputStream(request.getSession().getServletContext().getRealPath("/") + "upload/" + sdf.format(new Date())
                + fileName.substring(fileName.lastIndexOf(".")));
        fos.write(file.getBytes());
        fos.flush();
        fos.close();
    }

    /**
     * jump to page
     * url:	http://localhost:8080/mvc/page/{page}
     *
     * @param page
     * @return
     */
    @RequestMapping(value = "/page/{page}", method = RequestMethod.GET)
    public String page(@PathVariable("page") String page) {
        return page;
    }
}