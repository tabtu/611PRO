package uow.csse.bptzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uow.csse.bptzz.model.Department;
import uow.csse.bptzz.model.Student;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    @Query(value = "SELECT a.* FROM bptzz_student a JOIN bptzz_course b JOIN bptzz_student_course c WHERE a.student_id = c.student_id AND b.course_id = c.course_id AND b.course_id=?1", nativeQuery = true)
    List<Student> findByCourse_Course_id(String course_id);

//    @Transactional
//    @Modifying
//    @Query("update bptzz_student set firstname=?2, lastname=?3, profilepic=?4 where student_id=?1")
//    int updateStudent(long student_id, String firstname, String lastname, String profilepic);
}
