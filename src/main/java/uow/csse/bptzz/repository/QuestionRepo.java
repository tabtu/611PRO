package uow.csse.bptzz.repository;

import org.springframework.data.repository.CrudRepository;
import uow.csse.bptzz.model.Question;

public interface QuestionRepo extends CrudRepository<Question, Long> {
}
