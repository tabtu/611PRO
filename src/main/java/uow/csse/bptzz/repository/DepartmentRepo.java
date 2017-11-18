package uow.csse.bptzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uow.csse.bptzz.model.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

    Department findByName(String name);

}
