package uow.csse.bptzz.repository;

import org.springframework.data.repository.CrudRepository;
import uow.csse.bptzz.model.User;

public interface UserRepo extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User findByUsernameOrEmail(String email, String username);

    User findByEmail(String email);
}
