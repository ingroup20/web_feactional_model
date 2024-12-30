package com.t1.demo_web_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index {

    @GetMapping("/")
    public String sayHello(){
        return "index";
    }
}
