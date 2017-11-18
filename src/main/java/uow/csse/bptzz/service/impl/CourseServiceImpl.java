package uow.csse.bptzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uow.csse.bptzz.model.Course;
import uow.csse.bptzz.model.Department;
import uow.csse.bptzz.model.Question;
import uow.csse.bptzz.model.User;
import uow.csse.bptzz.repository.CourseRepo;
import uow.csse.bptzz.repository.DepartmentRepo;
import uow.csse.bptzz.repository.QuestionRepo;
import uow.csse.bptzz.repository.UserRepo;
import uow.csse.bptzz.service.CourseService;
import uow.csse.bptzz.utils.IterableUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CourseRepo cursRepo;

    @Autowired
    private QuestionRepo qustRepo;

    @Override
    public Course findCourseById(String corid) {
        return cursRepo.findOne(corid);
    }

    @Override
    public List<Course> findCoursesByName(String name) {
        return cursRepo.findByCourseName(name);
    }

    @Override
    public void saveCourse(Course course) {
        cursRepo.save(course);
    }

    @Override
    public void saveQuestion(Question question) {
        qustRepo.save(question);
    }

    @Override
    public List<Course> findCoursesByUsername(String username) {
        User user = userRepo.findByUsername(username);
        return user.getStudent().getCourses();
    }

    @Override
    public List<Course> findCoursesByDepartmentId(int department_id) {
        return null;//return cursRepo.fin(deptRepo.findOne(department_id));
    }
}
