package ru.gadjets.comppartapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.gadjets.comppartapp.service.PartPagerService;

//@SpringBootApplication
public class WebApp {
    @Autowired
    public static PartPagerService partPagerService;
    public static void main(String[] args) {

//        System.out.println(partPagerService.findAll());

//        SpringApplication.run(WebApp.class, args);
    }
}
