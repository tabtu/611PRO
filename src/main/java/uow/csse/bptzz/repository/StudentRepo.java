package uow.csse.bptzz.repository;

import org.springframework.data.repository.CrudRepository;
import uow.csse.bptzz.model.Student;

import java.util.List;

public interface StudentRepo extends CrudRepository<Student, Long> {

    Student findByStudent_id(Long student_id);
    List<Student> findStudentByS_department(Integer department_id);

}