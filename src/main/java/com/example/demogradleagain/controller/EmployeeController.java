package com.example.demogradleagain.controller;

import com.example.demogradleagain.model.Departments;
import com.example.demogradleagain.model.Employee;
import com.example.demogradleagain.repo.EmployeeRepository;
import com.example.demogradleagain.service.DeptsService;
import com.example.demogradleagain.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DeptsService deptsService;

    @GetMapping("/employees")
    public String displayEmployees(Model model) {

        Employee employee2 = new Employee();
        Departments departments = new Departments();
        model.addAttribute("employeeDetails", employeeService.getEmployeesList());
        model.addAttribute("");
        System.out.println("@Query -- Sum of emp salary: " + employeeRepository.getSumOfSalary());
        //System.out.println("Sum of dept: " + employeeRepository.getSalOfDept("Literature"));
        model.addAttribute("employee", employee2);
        return "displayempsintable"; // name of .jsp
    }

    @GetMapping("/")
    public String displayEmpsInTable(Model model) {
        Employee employee2 = new Employee();
        model.addAttribute("employeeDetails", employeeService.getEmployeesList());
        model.addAttribute("employee", employee2);
        System.out.println("Controller: Display all data");
        return "redirect:/employees"; // name of .jsp
    }

    @GetMapping("/api/restEmployees")
    public List<Employee> displayEmployeesRest(Model model) {
        System.out.println("Employee details are: ");
        model.addAttribute("employeeDetails", employeeService.getEmployeesList());
        System.out.println(employeeService.getEmployeesList());
        return employeeService.getEmployeesList(); // name of .jsp
    }

    @PostMapping("/addEmployee")
    public String submit(Model model, @Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        model.addAttribute("employeeDetails", employeeService.getEmployeesList());
        if (bindingResult.hasErrors()) {
            return "displayempsintable";
        }
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/editEmployee/{empId}")
    public String editEmp(@PathVariable(value = "empId") Integer empId, Model model) {
        System.out.println("empId: " + empId);
        model.addAttribute("empModel", employeeService.getEmployee(empId));
        return "edit_emp";
    }

    @PostMapping("editEmployee/updateEmployee")
    public String updateEmp(Employee employee, Model model) {
        model.addAttribute("employeeDetails", employeeService.getEmployeesList());
        employeeService.modifyEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmp(@RequestParam Integer empId) {
        System.out.println("Controller: in deleteEmp. empId received: " + empId);
        //employeeService.deleteEmployee(empId);
        employeeService.deleteEmpByIdJpaRepo(empId);
        return "redirect:/";
    }

    @GetMapping("findByLastName")
    public String findsById(@RequestParam String lastName, Model model) {
        System.out.println("in Controller - " + lastName);
        System.out.println(" " + employeeService.findByLastNameJpaRepo(lastName));
        ;
        model.addAttribute("employeeDetails", employeeService.findByLastNameJpaRepo(lastName));
        model.addAttribute("employee", new Employee());

        return "displayempsintable";
    }

    @ModelAttribute("depts")
    public List<String> listOfDepts() {
        List<String> depts = new ArrayList<>();
        depts.add("IT");
        depts.add("Marketing");
        depts.add("Literature");
        depts.add("Ops");

        return depts;
    }

    @GetMapping("/depts")
    public String navigateToDepartments(Model model) {
        model.addAttribute("deptDtls", deptsService.getAllDepartments());
        return "departments";
    }

    @GetMapping("/deleteDept")
    public String deleteDept(@RequestParam Integer deptId, Model model) {
        System.out.println("Controller: in deleteDept. deptId received: " + deptId);
        if (deptsService.getCountOfDepts(deptId) < 1) {
            deptsService.deleteDeptById(deptId);
            return "redirect:depts";
        }
        else {
            String errorMsg = "Dept. cannot be deleted. The department is mapped to at least 1 Employee.";
            System.out.println(errorMsg);
            model.addAttribute("errorMessage", "The dept can't be deleted.");
            model.addAttribute("exceptionVerbose", errorMsg);
            return "error";
        }
    }
}
