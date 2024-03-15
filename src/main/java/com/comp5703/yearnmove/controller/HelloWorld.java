package com.comp5703.yearnmove.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloWorld {
    @RequestMapping("/helloworld")
    public String helloworld(){
        return "Hello World";
    }
}
