package com.example.demogradleagain.repo;

import com.example.demogradleagain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by v.daniel.gunturu on 7/30/2019
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> findByLastName(String lastName);
    public Employee findByFirstName(String firstName);

    @Query("SELECT SUM(salary) FROM Employee")
    public Double getSumOfSalary();

//    @Query("SELECT SUM(salary) FROM Employee where dept=:dept")
//    public Double getSalOfDept(@Param("dept") String dept);

    @Modifying
    @Query("delete FROM Employee where emp_id=:id")
    public void deleteEmpById(@Param("id") Integer id);

    @Query("SELECT COUNT(*) FROM Employee WHERE deptId=:deptId")
    public Integer getCountForDept(@Param("deptId") Integer deptId);
}