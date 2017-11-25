package uow.csse.bptzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uow.csse.bptzz.model.Course;
import uow.csse.bptzz.model.Department;

import java.util.List;

/**
 * @author 	Tab Tu
 * @update	Nov.19 2017
 * @version	1.0
 */

@Repository
public interface CourseRepo extends JpaRepository<Course, String> {

    List<Course> findByCourseName(String string);

    List<Course> findByTextbook(String string);

    List<Course> findByDay(String day);

    @Query(value = "SELECT * FROM bptzz_course WHERE course_department=?1", nativeQuery = true)
    List<Course> findByC_department(long deptid);


}