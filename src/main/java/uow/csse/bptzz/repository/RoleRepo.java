package uow.csse.bptzz.repository;

import org.springframework.data.repository.CrudRepository;
import uow.csse.bptzz.model.Role;
import uow.csse.bptzz.model.User;

public interface RoleRepo extends CrudRepository<User, String> {

}
