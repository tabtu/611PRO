package uow.csse.bptzz.service;

import uow.csse.bptzz.model.Question;

import java.util.List;

public interface QuizService {

    List<Question> getTop10Questions(String corsid);

    List<Question> getQuestionsByCourseId(String course_id);

    Question getQuestionById(long qustid);

    double checkResult(long[] questions, String[] answers);

    String[] getAnswersByQuestionsId(long[] questions);

    String getAnswerByQuestionId(long question_id);

    List<Question> findQuestionsByContent(String name);
}
