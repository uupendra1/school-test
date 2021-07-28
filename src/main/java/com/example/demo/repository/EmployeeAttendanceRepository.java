package com.example.demo.repository;

import com.example.demo.model.EmployeeAttendance;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

public interface EmployeeAttendanceRepository extends CrudRepository<EmployeeAttendance, Integer> {
    @Query("SELECT e FROM employee_attendance e WHERE e.entry_date = ?1")
    Collection<EmployeeAttendance> getAttendanceByDate(String date);

    @Query("SELECT e FROM employee_attendance e WHERE e.employee_id = ?1")
    Optional<EmployeeAttendance> getByID(String empID);

    @Query("UPDATE employee_attendance set logout_time=?1 where employee_id=?2 and entry_date=?3")
    @Transactional
    @Modifying
    int updateLogoutTime(String logoutTime, Integer empID, String entryDate);
}