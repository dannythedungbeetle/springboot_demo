package com.example.demogradleagain.repo;

import com.example.demogradleagain.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by v.daniel.gunturu on 7/24/2019
 */
@Repository
public class EmployeeRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;
    String insertStmt = "INSERT INTO EMP_DTLS (DEPT, FIRST_NAME, LAST_NAME, SALARY, EMAIL) VALUES (?, ?, ?, ?, ?)";
    String selectStmt = "SELECT * FROM EMP_DTLS";

    public void addEmpToTable(Employee employee) {
        System.out.println("**Adding from JdbcTemplate**");
        jdbcTemplate.update(insertStmt, employee.getDeptId(), employee.getFirstName(), employee.getLastName(), employee.getSalary());

    }

}
