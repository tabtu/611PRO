package uow.csse.bptzz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uow.csse.bptzz.dao.EmployeeDAO;
import uow.csse.bptzz.service.EmployeeManager;
import uow.csse.bptzz.model.EmployeeVO;

@Service
public class EmployeeManagerImpl implements EmployeeManager {

    @Autowired
    EmployeeDAO dao;

    public List<EmployeeVO> getAllEmployees()
    {
        return dao.getAllEmployees();
    }
}