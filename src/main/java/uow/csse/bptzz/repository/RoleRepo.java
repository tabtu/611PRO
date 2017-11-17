package uow.csse.bptzz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uow.csse.bptzz.model.User;

@Repository
public interface RoleRepo extends CrudRepository<User, Long> {

}
