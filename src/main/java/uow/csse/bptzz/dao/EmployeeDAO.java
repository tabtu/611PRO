package uow.csse.bptzz.dao;

import uow.csse.bptzz.model.EmployeeVO;
import java.util.List;

public interface EmployeeDAO
{
    public List<EmployeeVO> getAllEmployees();
}