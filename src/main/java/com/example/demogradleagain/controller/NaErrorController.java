//package com.example.demogradleagain.controller;
//
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//@Controller
//public class NaErrorController implements ErrorController {
//
//    @GetMapping("/error")
//    public String error(Model model) {
//        model.addAttribute("errorMessage", "Page Not Found!!!!!!");
//        return "error";
//    }
//
//    @Override
//    public String getErrorPath() {
//        return "/error";
//    }
//}
