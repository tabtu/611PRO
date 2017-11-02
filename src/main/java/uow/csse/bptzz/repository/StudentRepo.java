package uow.csse.bptzz.repository;

import org.springframework.data.repository.CrudRepository;
import uow.csse.bptzz.model.Student;

public interface StudentRepo extends CrudRepository<Student, String> {

}
