package uow.csse.bptzz.service;

import uow.csse.bptzz.model.Course;
import uow.csse.bptzz.model.Department;
import uow.csse.bptzz.model.Question;

import java.util.List;

public interface CourseService {

    Course findCourseById(String corid);

    List<Course> findCoursesByName(String name);

    void saveCourse(Course course);

    void saveQuestion(Question question);

    List<Course> findCoursesByUsername(String username);

    List<Course> findCoursesByDepartmentId(int department_id);
}
