package uow.csse.bptzz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uow.csse.bptzz.model.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {

    Student findOne(long along);
}
