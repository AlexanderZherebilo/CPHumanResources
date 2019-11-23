package com.springproject.ZherebiloAV.repos;

import com.springproject.ZherebiloAV.domain.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepo extends CrudRepository<Department, Long> {
    Department findById(Integer id);
}
