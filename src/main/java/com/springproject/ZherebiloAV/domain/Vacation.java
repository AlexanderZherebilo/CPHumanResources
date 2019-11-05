package com.springproject.ZherebiloAV.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer number;
    private String type;
    private Date start;
    private Date finish;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "employee_id")
    private Employee employee;

    public Vacation() {
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
