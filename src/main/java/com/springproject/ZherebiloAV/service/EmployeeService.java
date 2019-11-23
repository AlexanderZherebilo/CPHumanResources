package com.springproject.ZherebiloAV.service;

import com.springproject.ZherebiloAV.domain.*;
import com.springproject.ZherebiloAV.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    @Autowired
    private SalaryRepo salaryRepo;

    @Autowired
    private VacationRepo vacationRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private PositionRepo positionRepo;

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
                               String gender, String marital, String address, String telephone,
                               String series, int number, String issuedBy, Date issueDate) {
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
        departmentRepo.save(employee.getDepartment());
        positionRepo.save(employee.getPosition());
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

    public void deleteEmployee(Employee employee) {employeeRepo.delete(employee);}

    public void setSalary(Integer personnelNumber, String type, String currency, BigDecimal value, Date start, Date dateOfIssue) {
        Employee employee = employeeRepo.findByPersonnelNumber(personnelNumber);
        if (employee.getSalary() == null) {
            employee.setSalary(new Salary());
            employee.getSalary().setEmployee(employee);
        }
        employee.getSalary().setType(type);
        employee.getSalary().setCurrency(currency);
        employee.getSalary().setValue(value);
        employee.getSalary().setStart(start);
        employee.getSalary().setDateOfOrder(dateOfIssue);
        employeeRepo.save(employee);
        salaryRepo.save(employee.getSalary());
    }

    public void giveVacation(Integer personnel, String type, Date start, Date finish) {
        Employee employee = employeeRepo.findByPersonnelNumber(personnel);
        if (employee.getVacation() == null) {
            employee.setVacation(new Vacation());
            employee.getVacation().setEmployee(employee);
        }
        employee.getVacation().setType(type);
        employee.getVacation().setStart(start);
        employee.getVacation().setFinish(finish);
        employeeRepo.save(employee);
        vacationRepo.save(employee.getVacation());
    }

    public void deleteVacation(Employee employee) {
        vacationRepo.delete(employee.getVacation());
    }
}
