package uow.csse.bptzz.repository;

import org.springframework.data.repository.CrudRepository;
import uow.csse.bptzz.model.Classroom;

public interface ClassroomRepo extends CrudRepository<Classroom, String> {
}
