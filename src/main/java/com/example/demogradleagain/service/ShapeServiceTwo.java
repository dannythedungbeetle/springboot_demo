package com.example.demogradleagain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.example.demogradleagain.model.Test;


import java.util.ArrayList;
import java.util.List;

@Component
public class ShapeServiceTwo {

    @Autowired
    Test test;


    // Qualifier will take the name of the method we are invoking
    @Autowired
    @Qualifier("testOne")
    Test potato;

    @Bean
    private Test test() {
        List<String> strList = new ArrayList<>();
        strList.add("Data 1");
        strList.add("Data 2");

        return new Test(strList);
    }

    @Bean
    private Test testOne() {
        List<String> strList = new ArrayList<>();
        strList.add("Data 3");
        strList.add("Data 4");

        return new Test(strList);
    }

    public void showList() {
        System.out.println("List contains:: "+test.getStringList());
        System.out.println("List contains:: "+potato.getStringList());
    }

}
