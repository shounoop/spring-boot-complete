package com.shounoop.springboot.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private String welcomeMessage = "Hello World!";

    @GetMapping("/")
    public String helloWorld() {
        return welcomeMessage;
    }
}
