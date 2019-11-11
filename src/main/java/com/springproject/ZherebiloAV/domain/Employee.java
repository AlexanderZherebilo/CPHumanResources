package com.springproject.ZherebiloAV.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "personnel_number")
    private Integer personnelNumber;
    @Column(name = "retirement_code")
    private Integer retirementCode;
    private String education;
    @Column(name = "marital_status")
    private String maritalStatus;
    private String address;
    private String telephone;
    private String photo;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL) //параметр optional писать только если наличие связанных записей в обеих таблицах обязательно
    private User account;                              //в противном случае это может привести к невозможности авторизации с данным аккаунтом

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<FamilyMember> members;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Passport passport;

    @OneToOne(mappedBy = "employee")
    private Salary salary;

    @OneToOne(mappedBy = "employee")
    private Vacation vacation;

    @OneToOne(mappedBy = "employee")
    private Learning learning;

    public Employee() {
    }

    public Employee(Integer personnelNumber, Integer retirementCode, String education, String maritalStatus, String address, String telephone, Passport passport) {
        this.personnelNumber = personnelNumber;
        this.retirementCode = retirementCode;
        this.education = education;
        this.maritalStatus = maritalStatus;
        this.address = address;
        this.telephone = telephone;
        this.passport = passport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPersonnelNumber() {
        return personnelNumber;
    }

    public void setPersonnelNumber(Integer personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    public Integer getRetirementCode() {
        return retirementCode;
    }

    public void setRetirementCode(Integer retirementCode) {
        this.retirementCode = retirementCode;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public User getAccount() {
        return account;
    }

    public void setAccount(User account) {
        this.account = account;
    }

    public List<FamilyMember> getMembers() {
        return members;
    }

    public boolean hasRelatives() {return members.size()!=0?true:false;}

    public String getMarrige() {
        String[] res = maritalStatus.split("/");
         if (passport.getGender().equals("Мужской"))
             return res[0];
         else return res[1];
    }

    public boolean hasAccount() {
        if (account == null)
            return false;
        else return true;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Salary getSalary() {
        return salary;
    }

    public Vacation getVacation() {
        return vacation;
    }

    public void setVacation(Vacation vacation) {
        this.vacation = vacation;
    }

    public Learning getLearning() {
        return learning;
    }

    public void setLearning(Learning learning) {
        this.learning = learning;
    }


}
