package com.example.demogradleagain.controller;

import org.hibernate.hql.internal.QueryExecutionRequestException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by v.daniel.gunturu on 8/1/2019
 */

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(QueryExecutionRequestException.class)
    public String showException(Model model, Exception e) {
        model.addAttribute("errorMessage", "Uh oh! Something went wrong. "+e.getMessage());
        return "error";
    }

    @ExceptionHandler(NullPointerException.class)
    public String showExceptionOne(Model model, Exception e) {
        model.addAttribute("errorMessage", "Something went wrong again. "+e.getMessage());
        return "error";
    }

    @ExceptionHandler(IllegalStateException.class)
    public String showExceptionTwo(Model model, Exception e) {
        model.addAttribute("errorMessage", "Illegal stuff ");
        model.addAttribute("exceptionVerbose", e.getMessage());
        return "error";
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleRunTime(Model model, Exception e) {
        model.addAttribute("errorMessage", "Runtime!!!!");
        model.addAttribute("exceptionVerbose", e.getMessage());
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String showExceptionMaster(Model model, Exception e) {
        model.addAttribute("errorMessage", "Master");
        model.addAttribute("exceptionVerbose", e.getMessage());
        return "error";
    }
}
