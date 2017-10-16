package uow.csse.bptzz.dao;

import org.springframework.data.repository.CrudRepository;

public interface bptzz_CourseRepo extends CrudRepository<bptzz_Course, String> {
    //need to research for two primary keys input string
}
