package uow.csse.bptzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uow.csse.bptzz.model.Question;
import uow.csse.bptzz.repository.CourseRepo;
import uow.csse.bptzz.repository.QuestionRepo;
import uow.csse.bptzz.service.QuizService;
import uow.csse.bptzz.utils.IterableUtil;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuestionRepo qustrepo;

    @Autowired
    private CourseRepo corsrepo;


    @Override
    public Question[] get10Questions(String corsid) {
        Question[] result = new Question[1];
//        Iterable<Question> alq = qustrepo.findByCourse(corsrepo.findOne(corsid));
//        List<Question> tmp = IterableUtil.makeList(alq);
//        result[0] = tmp.get(0);
        return result;
    }

    @Override
    public Question getQuestionById(long qustid) {
        return qustrepo.findOne(qustid);
    }
}
