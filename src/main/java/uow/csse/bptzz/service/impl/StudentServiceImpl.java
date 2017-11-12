package uow.csse.bptzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uow.csse.bptzz.model.Student;
import uow.csse.bptzz.repository.StudentRepo;
import uow.csse.bptzz.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student findByStudent_id(Long student_id) {
        return studentRepo.findByStudent_id(student_id);
    }

    @Override
    public List<Student> findStudentByS_department(Integer department_id) {
        return studentRepo.findStudentByS_department(department_id);

    }

}
