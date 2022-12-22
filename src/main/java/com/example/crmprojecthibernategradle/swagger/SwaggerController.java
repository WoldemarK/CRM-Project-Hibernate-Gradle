package com.example.crmprojecthibernategradle.swagger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swagger")
public class SwaggerController {
    @GetMapping()
    public String showSwagger() {
        return "swagger-ui.html";
    }
}
