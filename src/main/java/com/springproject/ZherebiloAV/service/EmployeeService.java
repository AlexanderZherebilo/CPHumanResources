package com.springproject.ZherebiloAV.service;

import com.springproject.ZherebiloAV.domain.Employee;
import com.springproject.ZherebiloAV.repos.EmployeeRepo;
import com.springproject.ZherebiloAV.repos.LearningRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private LearningRepo learningRepo;

    public Employee getByPersonnel(int number) {
        return employeeRepo.findByPersonnelNumber(number);
    }

    public void updateLearning(Employee employee, String education, String institution, String form, String faculty,
                               String speciality, String qualification, Date start, Date finish) {
        employee.setEducation(education);
        employee.getLearning().setInstitution(institution);
        employee.getLearning().setForm(form);
        employee.getLearning().setFaculty(faculty);
        employee.getLearning().setSpeciality(speciality);
        employee.getLearning().setQualification(qualification);
        employee.getLearning().setStart(start);
        employee.getLearning().setFinish(finish);
        learningRepo.save(employee.getLearning());
        employeeRepo.save(employee);
    }

    public void updateEmployee(Employee employee) {

    }
}
