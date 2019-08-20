package com.example.demogradleagain.service;

import com.example.demogradleagain.model.Departments;
import com.example.demogradleagain.repo.DepartmentsRepository;
import com.example.demogradleagain.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by v.daniel.gunturu on 8/18/2019
 */
@Service
public class DeptsService {

    @Autowired
    DepartmentsRepository repository;
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Departments> getAllDepartments() {
        List<Departments> departments = repository.findAll();

        return departments;
    }

    public void deleteDeptById(Integer deptId) {
        repository.deleteById(deptId);
    }

    public Departments findDeptById(Integer deptId) {
        return repository.getOne(deptId);
    }

    public Integer getCountOfDepts(Integer deptId) {
        Integer count = employeeRepository.getCountForDept(deptId);
        System.out.println("getCountForDept - Count:: " + count);
        return count;
    }
}