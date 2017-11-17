package uow.csse.bptzz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uow.csse.bptzz.model.User;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    User findOne(long uid);

    User findByUsername(String username);

    User findByUsernameOrEmail(String email, String username);

    User findByEmail(String email);

    List<User> findByStudent_Gender(boolean gender);
}
