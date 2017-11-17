package uow.csse.bptzz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uow.csse.bptzz.model.Course;
import uow.csse.bptzz.model.Question;

import java.util.List;

@Repository
public interface QuestionRepo extends CrudRepository<Question, Long> {

    Question findOne(Long aLong);

    //Iterable<Question> findByCourse(Course course);

    List<Question> findByCourse(Course course);

    //List<Question> findByCourse_Course_id(String course_id);

    //List<Question> findByCourse_Course_id(String course_id);

//    List<Question> findByCourse_Course_id(String course_id);
}
