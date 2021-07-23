package com.example.demo.controller;

import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Map;

@RestController
@RequestMapping("school/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping(path = "login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody Map<String, Long> map) {
        Time time = new Time(System.currentTimeMillis());
        teacherService.login(map.get("empID"), time);
        return "Login Successful";
    }

    @PostMapping(path = "logout", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String logout(@RequestBody Map<String, Long> map) {
        Time time = new Time(System.currentTimeMillis());
        teacherService.logout(map.get("empID"), time);
        return "Logout Successful";
    }
}
