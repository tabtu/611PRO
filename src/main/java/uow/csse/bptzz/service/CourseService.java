package uow.csse.bptzz.service;

import uow.csse.bptzz.model.Course;

public interface CourseService {
    Course findCourseById(String corid);
}
