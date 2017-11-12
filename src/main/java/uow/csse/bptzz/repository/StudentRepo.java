package uow.csse.bptzz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uow.csse.bptzz.model.Student;

import java.util.List;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {

//    Student findStudentByStudent_id(Long student_id);
//    List<Student> findStudentByS_department(Integer department_id);

}
