package uow.csse.bptzz.repository;

import org.springframework.data.repository.CrudRepository;
import uow.csse.bptzz.model.Department;

public interface DepartmentRepo extends CrudRepository<Department, Integer> {

}
