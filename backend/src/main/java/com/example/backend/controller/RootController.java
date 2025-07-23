package com.example.backend.controller; // Make sure this package name is correct!

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @GetMapping("/") // This annotation maps the root URL ("/") to this method
    public String welcome() {
        return "Welcome to the Water Quality Monitoring API. It's working!";
    }
}