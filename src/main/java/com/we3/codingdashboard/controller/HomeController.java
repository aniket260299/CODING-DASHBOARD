package com.we3.codingdashboard.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String sayHello() {
        return "Hello 👋";
    }
}
