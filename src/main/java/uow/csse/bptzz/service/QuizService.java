package uow.csse.bptzz.service;

import uow.csse.bptzz.model.Question;

public interface QuizService {
    Question[] get10Questions(String corsid);

    Question getQuestionById(long qustid);
}
