package com.example.demo.service;

import com.example.demo.model.EmployeeAttendance;
import com.example.demo.repository.EmployeeAttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Time;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    EmployeeAttendanceRepository employeeAttendanceRepository;

    public void login(EmployeeAttendance employeeAttendance) {
        System.out.println("EmployeeID: " + employeeAttendance.getEmployee_id() + "\nLogin Time: " + employeeAttendance.getLogin_time());
        employeeAttendanceRepository.save(employeeAttendance);
    }

    public Collection<EmployeeAttendance> getAttendanceByDate(String entryDate) {
        return employeeAttendanceRepository.getAttendanceByDate(entryDate);
    }

    public Optional<EmployeeAttendance> findByID(Integer empID) {
        return employeeAttendanceRepository.findById(empID);
    }

    @Transactional
    public void logout(EmployeeAttendance employeeAttendance) {
        employeeAttendanceRepository.deleteById(employeeAttendance.getEmployee_id());
        employeeAttendanceRepository.updateLogoutTime(employeeAttendance.getLogout_time(),
                employeeAttendance.getEmployee_id(),
                employeeAttendance.getEntry_date());
    }
}
