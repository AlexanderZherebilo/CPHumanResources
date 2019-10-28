package com.springproject.ZherebiloAV.service;

import com.springproject.ZherebiloAV.domain.Employee;
import com.springproject.ZherebiloAV.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee getById(int id) {
        return employeeRepo.findById(id);
    }
}
