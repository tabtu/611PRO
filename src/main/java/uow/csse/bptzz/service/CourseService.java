package uow.csse.bptzz.service;

import uow.csse.bptzz.model.Course;
import uow.csse.bptzz.model.Department;

import java.util.List;

public interface CourseService {

    Course findCourseById(String corid);

    List<Course> findCourseByName(String name);

    void saveCourse(Course course);

    void saveDepartment(Department department);

    List<Course> findCourseByUsername(String username);

    List<Course> findCourseByDepartmentId(int department_id);
}
