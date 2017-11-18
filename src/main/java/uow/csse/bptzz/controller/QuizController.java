package uow.csse.bptzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import uow.csse.bptzz.model.Course;
import uow.csse.bptzz.model.Question;
import uow.csse.bptzz.service.CourseService;
import uow.csse.bptzz.service.QuizService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class QuizController extends BaseController {
    @Autowired
    private QuizService questionv;

    @RequestMapping(value = "/quiz{course_id}", method = RequestMethod.GET)
    public ModelAndView getQuiz(HttpServletRequest request) {
        String course_id = request.getParameter("course_id");
        Question[] questions = questionv.get10Questions(course_id);

        ModelAndView mav = new ModelAndView("quiz");
        mav.addObject("questions", questions);

        return mav;
    }

    @RequestMapping(value = "/quiz", method = RequestMethod.POST)
    public ModelAndView postQuiz(List<Question> questions) {
//
        //it is better to use session("username") to display the username on webpage by front-end,
        //not necessary to return by controller
        //String username = "";
        int correctnum = 0;
        int incorrectnum = 0;
        double score = 0.0;

        for (Question question : questions) {
            if (question.getAnswer() == questionv.getQuestionById(question.getQuestion_id()).getAnswer() )
            {
                correctnum += 1;
                score += 10.0;

            } else {
                incorrectnum += 1;
            }

        }

        ModelAndView mav = new ModelAndView("assessment");
        //it is better to use session("username") to display the username on webpage,
        //not necessary to return by controller
        //mav.addObject("username", username);
        mav.addObject("correctnum", correctnum);
        mav.addObject("incorrectnum", incorrectnum);
        mav.addObject("score", score);

        return mav;
    }


}
