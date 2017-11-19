package uow.csse.bptzz.service;

import uow.csse.bptzz.model.Department;
import uow.csse.bptzz.model.Student;
import uow.csse.bptzz.model.User;

import java.util.List;

public interface UserService {
    User findUserByUsername(String username);

    User findUserByEmail(String email);

    User findUserByUsernameOrEmail(String email, String username);

    List<Student> findStudentByUserIsUsing(boolean enable);

    Student findStudentByUsername(String username);

    void saveUser(User user);

    void saveStudent(Student student);

    void saveDepartment(Department dept);

    void updateUser(User user);

    void updateStudent(Student student);
}