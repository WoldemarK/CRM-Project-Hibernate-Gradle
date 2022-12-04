package com.example.CRMProject.company.controller;

import com.example.CRMProject.company.model.Company;
import com.example.CRMProject.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService service;
    @GetMapping("/all")
    public ResponseEntity<List<Company>>getAll(){
       return ResponseEntity.ok(service.findAll());
    }
    @PostMapping("/save")
    public ResponseEntity<Company>save(@RequestBody Company company){
        return ResponseEntity.ok(service.save(company));
    }
}
