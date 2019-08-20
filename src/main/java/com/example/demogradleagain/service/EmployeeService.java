package com.example.demogradleagain.service;

import com.example.demogradleagain.model.Departments;
import com.example.demogradleagain.model.Employee;
import com.example.demogradleagain.repo.EmployeeRepo;
import com.example.demogradleagain.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;
    public static Map<Integer, Employee> employeeMap = new HashMap<>();
    public static int empId = 10089;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DeptsService deptsService;



    // add from UI
    public void addEmployee(Employee empObj) {
        empId = empId+10;
        employeeMap.put(empId, empObj);
        employeeRepo.addEmpToTable(empObj);
        //employeeRepository.save(empObj);
    }
    // delete
    public void deleteEmployee(Integer empId) {
        System.out.println("deleteEmployee: attempting removal for "+empId);
        //employeeMap.remove(empId);
        employeeRepository.deleteById(empId);
    }
    //modify
    public void modifyEmployee(Employee employee) {
        System.out.println("In modifyEmployee");
        //employeeMap.put(employee.getEmpId(), employee);
        employeeRepository.save(employee);
    }

    public Employee getEmployee(Integer empId) {
//        Employee employee = employeeMap.get(empId);
        Employee employee = employeeRepository.findById(empId).get();
        System.out.println("Employee.getEmployee - empId: "+empId);
        //System.out.println("employeeMap.get.getFirstName: "+employeeMap.get(empId).getFirstName());
        if (employee==null)
            System.out.println("Invalid data");
        else {
            //System.out.println("EmployeeService.getEmployee - empId received: "+empId+" firstName: "+employee.getFirstName()
              //  +", lastName: "+employee.getLastName());
        }
        return employee;
    }

    public List<Employee> getEmployeesList() {
        List<Employee> employeesList = employeeRepository.findAll();
        for(Employee emp : employeesList) {
            Departments department = deptsService.findDeptById(emp.getDeptId());
            emp.setDeptLongDesc(department.getDeptLongDesc());
        }
        return employeeRepository.findAll();
    }

    @Transactional
    public void deleteEmpByIdJpaRepo(Integer id) {
        employeeRepository.deleteEmpById(id);
    }

    public List<Employee> findByLastNameJpaRepo(String lastName) {
        return employeeRepository.findByLastName(lastName);
    }

    static {
        Employee employee = new Employee();
        employee.setEmpId(10049);
        employee.setFirstName("Victor");
        employee.setLastName("Gunturu");
        employee.setSalary(1000.00);
        employee.setDeptId(01);
        Employee employeeOne = new Employee();
        employeeOne.setEmpId(10059);
        employeeOne.setFirstName("Marshall");
        employeeOne.setLastName("Mathers");
        employeeOne.setSalary(1080.00);
        employeeOne.setDeptId(03);
        employeeMap.put(10049, employee);
        employeeMap.put(10059, employeeOne);
    }

}
