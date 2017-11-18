package uow.csse.bptzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uow.csse.bptzz.model.User;

@Repository
public interface RoleRepo extends JpaRepository<User, Long> {

}
