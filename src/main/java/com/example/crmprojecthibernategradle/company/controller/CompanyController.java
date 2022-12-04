package com.example.crmprojecthibernategradle.company.controller;


import com.example.crmprojecthibernategradle.company.model.Company;
import com.example.crmprojecthibernategradle.company.service.CompanyService;
import jakarta.validation.Valid;
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
    public ResponseEntity<List<Company>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Company> save(@RequestBody Company company) {
        return ResponseEntity.ok(service.save(company));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getId(@Valid @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @PathVariable(name = "id") Long id) {
        service.delete(id);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Company>> getNames(@Valid @RequestParam(name = "name") String name) {
        return ResponseEntity.ok(service.findByName(name));
    }
    @GetMapping("/phone")
    public ResponseEntity<Company> getPhone(@Valid @RequestParam(name = "phone") String phone) {
        return ResponseEntity.ok(service.findByPhoneNumber(phone));
    }
}
