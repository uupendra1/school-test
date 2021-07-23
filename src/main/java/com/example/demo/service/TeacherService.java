package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.sql.Time;

@Service
public class TeacherService {
    public void login(long empID, Time loginTime) {
        System.out.println("EmployeeID: " + empID + "\nLogin Time: " + loginTime);
    }

    public void logout(long empID, Time logoutTime) {
        System.out.println("EmployeeID: " + empID + "\nLogout Time: " + logoutTime);
    }
}
