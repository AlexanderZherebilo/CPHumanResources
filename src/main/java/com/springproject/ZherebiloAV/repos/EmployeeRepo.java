package com.springproject.ZherebiloAV.repos;

import com.springproject.ZherebiloAV.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {
    Employee findByPersonnelNumber(int number);
}
