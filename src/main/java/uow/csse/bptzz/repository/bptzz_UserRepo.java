package uow.csse.bptzz.repository;

import org.springframework.data.repository.CrudRepository;
import uow.csse.bptzz.model.bptzz_User;

public interface bptzz_UserRepo extends CrudRepository<bptzz_User, String> {
    //bptzz_User findByUsername(String username);
}
