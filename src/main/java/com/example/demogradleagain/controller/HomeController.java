package com.example.demogradleagain.controller;

import com.example.demogradleagain.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/home")
    public String home() {
        System.out.println("home called");
        System.out.println(employeeService.getEmployeesList());
        return "displayempsintable"; // name of .jsp
    }

    @GetMapping("/index")
    public String navigateIndexToNotHome() {
        System.out.println("not-home called");
        return "notHome"; // name of .jsp
    }

    @GetMapping("/potato")
    public String params(Model model) {
        System.out.println("potato called");
        model.addAttribute("name","Dan");
        return "potato"; // name of .jsp
    }



//    @GetMapping("/potato")
//    public String error(Model model) {
//        System.out.println("potato called");
//        model.addAttribute("name","Dan");
//        return "potato"; // name of .jsp
//    }

}
