package uow.csse.bptzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uow.csse.bptzz.model.Department;

/**
 * @author 	Tab Tu
 * @update	Nov.11 2017
 * @version	1.0
 */

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

    Department findByName(String name);

}
