package uow.csse.bptzz.repository;

import org.springframework.data.repository.CrudRepository;
import uow.csse.bptzz.model.Course;

public interface CourseRepo extends CrudRepository<Course, String> {

}