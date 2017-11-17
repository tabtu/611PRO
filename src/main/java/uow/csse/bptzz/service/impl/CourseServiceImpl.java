package uow.csse.bptzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uow.csse.bptzz.model.Course;
import uow.csse.bptzz.repository.CourseRepo;
import uow.csse.bptzz.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo cursRepo;

    @Override
    public Course findCourseById(String corid) {
        return cursRepo.findByCourse_id(corid);
    }
}
