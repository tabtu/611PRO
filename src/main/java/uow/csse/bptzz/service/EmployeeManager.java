package uow.csse.bptzz.service;

import uow.csse.bptzz.model.EmployeeVO;

import java.util.List;

public interface EmployeeManager
{
    public List<EmployeeVO> getAllEmployees();
}