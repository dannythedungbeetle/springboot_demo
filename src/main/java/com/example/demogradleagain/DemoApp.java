package com.example.demogradleagain;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;


@SpringBootApplication
public class DemoApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApp.class, args);
        String[] beans = context.getBeanDefinitionNames();
        //System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
        //Arrays.asList(beans).forEach(System.out::println);
    }
}
