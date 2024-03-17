package com.comp5703.yearnmove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/hello")
public class HelloWorld {
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("Hello World");
        return "Hello World";
    }
}
