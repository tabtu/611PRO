package uow.csse.bptzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uow.csse.bptzz.model.Course;
import uow.csse.bptzz.model.Question;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {

    @Query(value = "SELECT a.* FROM bptzz_question a JOIN bptzz_course b WHERE a.question_course = b.course_id AND b.course_id =?1", nativeQuery = true)
    List<Question> findByCourse_Course_id(String course_id);

    List<Question> findByContentLike(String content);
}
