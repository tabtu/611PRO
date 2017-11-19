package uow.csse.bptzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uow.csse.bptzz.model.Question;
import uow.csse.bptzz.repository.CourseRepo;
import uow.csse.bptzz.repository.QuestionRepo;
import uow.csse.bptzz.service.QuizService;
import uow.csse.bptzz.utils.IterableUtil;
import uow.csse.bptzz.utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuestionRepo qustrepo;

    @Override
    public List<Question> getTop10Questions(String corsid) {
        List<Question> alq = qustrepo.findByCourse_Course_id(corsid);
        if (alq.size() > 10) {
            List<Question> bc = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                bc.add(alq.get(i));
            }
            return bc;
        }
        return alq;
    }

    @Override
    public Question getQuestionById(long qustid) {
        return qustrepo.findOne(qustid);
    }

    @Override
    public List<Question> getQuestionsByCourseId(String course_id) {
        return qustrepo.findByCourse_Course_id(course_id);
    }

    @Override
    public double checkResult(long[] questions, String[] answers) {
        if (questions.length != answers.length) return -1;
        int N = questions.length;
        Question[] tmp = new Question[N];
        double result = 0;
        for(int i = 0; i < N; i++) {
            if(qustrepo.findOne(questions[i]).getAnswer() == answers[i]) result++;
        }
        result = result / N;
        return result;
    }

    @Override
    public String[] getAnswersByQuestionsId(long[] questions) {
        int N = questions.length;
        String[] result = new String[N];
        for (int i = 0; i < N; i++) {
            result[i] = qustrepo.findOne(questions[i]).getAnswer();
        }
        return result;
    }

    @Override
    public String getAnswerByQuestionId(long question_id) {
        return qustrepo.findOne(question_id).getAnswer();
    }

    @Override
    public List<Question> findQuestionsByContent(String content) {
        return qustrepo.findByContentLike(content);
    }
}
