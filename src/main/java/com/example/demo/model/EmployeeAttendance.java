package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "employee_attendance")
public class EmployeeAttendance {
    @Column
    @Id
    private Integer employee_id;

    @Column
    private String entry_date;

    @Column
    private String login_time;

    @Column
    private String logout_time;

    public EmployeeAttendance() {
        this.employee_id = null;
        this.entry_date = null;
        this.login_time = null;
        this.logout_time = null;
    }

    public EmployeeAttendance(Integer employee_id, String entry_date, String login_time, String logout_time) {
        this.employee_id = employee_id;
        this.entry_date = entry_date;
        this.login_time = login_time;
        this.logout_time = logout_time;
    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public String getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(String entry_date) {
        this.entry_date = entry_date;
    }

    public String getLogin_time() {
        return login_time;
    }

    public void setLogin_time(String login_time) {
        this.login_time = login_time;
    }

    public String getLogout_time() {
        return logout_time;
    }

    public void setLogout_time(String logout_time) {
        this.logout_time = logout_time;
    }
}
