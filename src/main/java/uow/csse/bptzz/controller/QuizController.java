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
import java.util.Map;

@RestController
public class QuizController extends BaseController {

    @Autowired
    private QuizService questionv;

    @RequestMapping(value = "/quiz{course_id}", method = RequestMethod.GET)
    public ModelAndView getQuiz(HttpServletRequest request) {
        String course_id = request.getParameter("course_id");
        List<Question> questions = questionv.getTop10Questions(course_id);

        ModelAndView mav = new ModelAndView("quiz");
        mav.addObject("questions", questions);

        return mav;
    }

    @RequestMapping(value = "/quiz", method = RequestMethod.POST)
    public ModelAndView postQuiz(HttpServletRequest request) {

        Map<String, String[]> parameterMap = request.getParameterMap();


        int correctNum = 0;
        int incorrectNum = 0;
        double score = 0.0;
        for (String key : parameterMap.keySet()) {
            String[] item = parameterMap.get(key);
            String answer = questionv.getQuestionById(Integer.parseInt(key)).getAnswer();

            if (null == item || item.length < 1) {
                continue;
            }

            if (answer.equalsIgnoreCase(item[0])) {
                correctNum++;
                score += 10.0;
            } else {
                incorrectNum ++;
            }

        }

        ModelAndView mav = new ModelAndView("assessment");
        //it is better to use session("username") to display the username on webpage,
        //not necessary to return by controller
        //mav.addObject("username", username);
        mav.addObject("correctNum", correctNum);
        mav.addObject("incorrectNum", incorrectNum);
        mav.addObject("score", score);


//        String[] qStrings= request.getParameter("quizString").split("\\s{1,}");
        //it is better to use session("username") to display the username on webpage by front-end,
        //not necessary to return by controller
        //String username = "";
//        int correctnum = 0;
//        int incorrectnum = 0;
//        double score = 0.0;

//        List<Question> questions
//        for (Question question : questions) {
//            if (question.getAnswer() == questionv.getQuestionById(question.getQuestion_id()).getAnswer() )
//            {
//                correctnum += 1;
//                score += 10.0;
//
//            } else {
//                incorrectnum += 1;
//            }
//
//        }

//        for (int i = 0; i < qStrings.length; i += 2) {
//            if (qStrings[i + 1] == questionv.getQuestionById(Integer.parseInt(qStrings[i])).getAnswer()) {
//                correctnum += 1;
//                score += 10.0;
//
//            } else {
//                incorrectnum += 1;
//            }
//
//
//        }
//


        return mav;
    }


}
