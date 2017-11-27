package uow.csse.bptzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uow.csse.bptzz.model.User;

/**
 * @author 	Tab Tu
 * @update	Oct.14 2017
 * @version	1.0
 */

@Repository
public interface RoleRepo extends JpaRepository<User, Long> {

}
