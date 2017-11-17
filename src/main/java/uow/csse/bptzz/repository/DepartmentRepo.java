package uow.csse.bptzz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uow.csse.bptzz.model.Department;

@Repository
public interface DepartmentRepo extends CrudRepository<Department, Integer> {

    Department findByName(String name);

    Department findOne(Integer integer);
}
