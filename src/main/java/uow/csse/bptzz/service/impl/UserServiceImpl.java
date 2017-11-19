package uow.csse.bptzz.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import uow.csse.bptzz.model.Department;
import uow.csse.bptzz.model.Role;
import uow.csse.bptzz.model.Student;
import uow.csse.bptzz.model.User;
import uow.csse.bptzz.repository.DepartmentRepo;
import uow.csse.bptzz.repository.RoleRepo;
import uow.csse.bptzz.repository.StudentRepo;
import uow.csse.bptzz.repository.UserRepo;
import uow.csse.bptzz.service.UserService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private StudentRepo studRepo;

    @Autowired
    private DepartmentRepo deptRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User findUserByUsernameOrEmail(String email, String username) { return userRepo.findByUsernameOrEmail(email, username); }

    @Override
    public User findUserByEmail(String email) { return userRepo.findByEmail(email); }

    @Override
    public List<Student> findStudentByUserIsUsing(boolean enable) {
        List<Student> result = new ArrayList<>();
        List<User> tmp = userRepo.findByEnabled(true);
        for(User t : tmp) {
            if(t.getStudent() != null) result.add(t.getStudent());
        }
        return result;
    }

    @Override
    public Student findStudentByUsername(String username) {
        return studRepo.findByUserUsername(username);
    }

    @Override
    public void saveStudent(Student student) {
        studRepo.save(student);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new ArrayList<Role>() {
        });
        userRepo.save(user);
    }

    @Override
    public void saveDepartment(Department dept) {
        deptRepo.save(dept);
    }

    @Override
    public void updateUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        userRepo.updateUser(user.getUser_id(), user.getUsername(), user.getPassword(), user.getEmail());
    }

    @Override
    public void updateStudent(Student student) {
//        studRepo.updateStudent();
    }
}
