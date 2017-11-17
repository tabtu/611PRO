package uow.csse.bptzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uow.csse.bptzz.model.Course;
import uow.csse.bptzz.model.Department;
import uow.csse.bptzz.model.User;
import uow.csse.bptzz.repository.CourseRepo;
import uow.csse.bptzz.repository.DepartmentRepo;
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
    private DepartmentRepo deptRepo;


    @Override
    public Course findCourseById(String corid) {
        return cursRepo.findOne(corid);
    }

    @Override
    public List<Course> findCourseByName(String name) {
        return IterableUtil.makeList(cursRepo.findByCourseName(name));
    }

    @Override
    public void saveCourse(Course course) {
        cursRepo.save(course);
    }

    @Override
    public void saveDepartment(Department department) {
        deptRepo.save(department);
    }

    @Override
    public List<Course> findCourseByUsername(String username) {
        User user = userRepo.findByUsername(username);
        Set<Course> courses = user.getStudent().getCourses();
        return new ArrayList<>(courses);
    }

    @Override
    public List<Course> findCourseByDepartmentId(int department_id) {

        return null; //cursRepo.fin(deptRepo.findOne(department_id));
    }
}
