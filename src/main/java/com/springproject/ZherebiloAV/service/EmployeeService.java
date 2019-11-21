package com.springproject.ZherebiloAV.service;

import com.springproject.ZherebiloAV.domain.Employee;
import com.springproject.ZherebiloAV.domain.FamilyMember;
import com.springproject.ZherebiloAV.domain.Learning;
import com.springproject.ZherebiloAV.domain.User;
import com.springproject.ZherebiloAV.repos.EmployeeRepo;
import com.springproject.ZherebiloAV.repos.FamilyMemberRepo;
import com.springproject.ZherebiloAV.repos.LearningRepo;
import com.springproject.ZherebiloAV.repos.PassportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PassportRepo passportRepo;

    @Autowired
    private LearningRepo learningRepo;

    @Autowired
    private FamilyMemberRepo familyMemberRepo;

    public Employee getByPersonnel(int number) {
        return employeeRepo.findByPersonnelNumber(number);
    }

    public void updateLearning(Integer personnel, String education, String institution, String form, String faculty,
                               String speciality, String qualification, Date start, Date finish) {
        Employee employee = employeeRepo.findByPersonnelNumber(personnel);
        employee.setEducation(education);
        if (employee.getLearning() == null) {
            employee.setLearning(new Learning());
            employee.getLearning().setEmployee(employee);
        }
        employee.getLearning().setInstitution(institution);
        employee.getLearning().setForm(form);
        employee.getLearning().setFaculty(faculty);
        employee.getLearning().setSpeciality(speciality);
        employee.getLearning().setQualification(qualification);
        employee.getLearning().setStart(start);
        employee.getLearning().setFinish(finish);
        employeeRepo.save(employee);
        learningRepo.save(employee.getLearning());
    }

    public void updateEmployee(Employee employee, String surname, String name, String lastname, Date birthday,
                               String gender, String marital, String address, String telephone, String series,
                               int number, String issuedBy, Date issueDate) {
        employee.getPassport().setSurname(surname);
        employee.getPassport().setName(name);
        employee.getPassport().setLastname(lastname);
        employee.getPassport().setBirthday(birthday);
        employee.getPassport().setGender(gender);
        employee.setMaritalStatus(marital);
        employee.setAddress(address);
        employee.setTelephone(telephone);
        employee.getPassport().setSeries(series);
        employee.getPassport().setNumber(number);
        employee.getPassport().setIssuedBy(issuedBy);
        employee.getPassport().setDateOfIssue(issueDate);
        passportRepo.save(employee.getPassport());
        employeeRepo.save(employee);
    }

    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<>();
        Iterable<Employee> it = employeeRepo.findAll();
        for (Employee e : it)
            list.add(e);
        return list;
    }

    public boolean saveEmployee(Employee employee) {
        employeeRepo.save(employee);
        passportRepo.save(employee.getPassport());
        return true;
    }

    public boolean addMember(User user, FamilyMember familyMember) {
        Employee employee = employeeRepo.findByPersonnelNumber(user.getEmployee().getPersonnelNumber());
        familyMember.setEmployee(employee);
        employee.getMembers().add(familyMember);
        familyMemberRepo.save(familyMember);
        employeeRepo.save(employee);
        return true;
    }

    public void deleteMember(FamilyMember member) {
        familyMemberRepo.delete(member);
    }

    public void deleteEmloyee(Employee employee) {employeeRepo.delete(employee);}
}
