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
    private String speciality;
    private String qualification;
    @Column(name = "marital_status")
    private String maritalStatus;
    private String address;
    private String telephone;
    private String photo;

    @OneToOne(optional = false, mappedBy = "employee")
    private User account;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<FamilyMember> members;

    @OneToOne(optional = false, mappedBy = "employee")
    private Passport passport;

    @OneToOne(optional = false, mappedBy = "employee")
    private Salary salary;

    public Employee() {
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
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

    public Passport getPassport() {
        return passport;
    }

    public Salary getSalary() {
        return salary;
    }
}
