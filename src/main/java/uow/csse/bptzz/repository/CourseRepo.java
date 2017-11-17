package uow.csse.bptzz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uow.csse.bptzz.model.Course;
import uow.csse.bptzz.model.Department;

import java.util.List;

@Repository
public interface CourseRepo extends CrudRepository<Course, String> {

    Course findOne(String string);

    List<Course> findByCourseName(String string);

    List<Course> findByTextbook(String string);

    List<Course> findByDay(String day);
}