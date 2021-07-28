package com.example.demo.controller;

import com.example.demo.model.EmployeeAttendance;
import com.example.demo.model.Student;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("school")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping(path = "teacher")
    public Map<String, String> postTeacherInfo(@RequestBody Map<String, String> teacher) {
        System.out.println("POST endpoint");
        return teacher;
    }

    @PostMapping(path = "login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody EmployeeAttendance employeeAttendance) {
        Time time = new Time(System.currentTimeMillis());
        employeeAttendance.setLogin_time(String.valueOf(time));
        teacherService.login(employeeAttendance);
        return "Login Successful";
    }

    @GetMapping(path = "attendance", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Collection<EmployeeAttendance> getAttendanceByDate(@RequestParam String entryDate) {
        return teacherService.getAttendanceByDate(entryDate);
    }

    @GetMapping(path = "attendance/id", consumes = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeAttendance getAttendanceByID(@RequestParam Integer empID) {
        Optional<EmployeeAttendance> employeeAttendance = teacherService.findByID(empID);
        if (!employeeAttendance.isEmpty()) {
            return employeeAttendance.get();
        } else {
            return null;
        }
    }

    @GetMapping(path = "teacher")
    public Map<String, String> getTeacherInfo(@RequestParam String empID) {
        System.out.println("GET endpoint");
        return new HashMap<>();
    }

    @PutMapping(path = "teacher")
    public Map<String, String> updateTeacherInfo(@RequestBody Map<String, String> teacher) {
        System.out.println("PUT endpoint");
        return teacher;
    }

    @DeleteMapping(path = "teacher")
    public Map<String, String> deleteTeacherInfo(@RequestParam String empID) {
        System.out.println("DELETE endpoint");
        return new HashMap<>();
    }

    @PostMapping(path = "logout", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String logout(@RequestBody EmployeeAttendance employeeAttendance) {
        Time time = new Time(System.currentTimeMillis());
        employeeAttendance.setLogout_time(String.valueOf(time));
        teacherService.logout(employeeAttendance);
        return "Logout Successful";
    }
}
