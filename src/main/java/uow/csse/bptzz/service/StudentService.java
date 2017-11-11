package uow.csse.bptzz.service;

import uow.csse.bptzz.model.Student;

import java.util.List;

public interface StudentService {

    Student findByStudent_id(Long student_id);
    List<Student> findStudentByS_department(Integer department_id);
}
