package com.springproject.ZherebiloAV.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Learning {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String institution;
    private String faculty;
    private String form;
    private String speciality;
    private String qualification;
    private Date start;
    private Date finish;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn (name = "employee_id")
    private Employee employee;

    public Learning() {
    }

    public Learning(String institution, String faculty, String form, String speciality, String qualification, Date start, Date finish) {
        this.institution = institution;
        this.faculty = faculty;
        this.form = form;
        this.speciality = speciality;
        this.qualification = qualification;
        this.start = start;
        this.finish = finish;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstitution() {
        return institution;
    }

    public String getShortInst() {
        String[] name = this.institution.split(" ");
        StringBuilder res = new StringBuilder();
        for (String s : name)
            if (s.length() != 1)
            res.append(s.charAt(0));
        return res.toString().toUpperCase();
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
