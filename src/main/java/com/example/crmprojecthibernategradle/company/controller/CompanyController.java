package com.example.crmprojecthibernategradle.company.controller;


import com.example.crmprojecthibernategradle.company.controller.exception.CompanyException;
import com.example.crmprojecthibernategradle.company.model.Company;
import com.example.crmprojecthibernategradle.company.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService service;
    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @GetMapping("/all")
    public ResponseEntity<Optional<List<Company>>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Company> save(@RequestBody Company company) {
        return ResponseEntity.ok(service.save(company)
                .orElseThrow(() ->
                        new CompanyException("An error occurred while saving, check the spelling of the input")));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Company>> getId(@Valid @PathVariable(name = "id") Long id) {
        logger.info("Providing the company with " + id);

        return ResponseEntity.ok(Optional.ofNullable(service.findById(id)
                .orElseThrow(() -> new CompanyException("The requested company does not exist"))));

    }

    @PutMapping("/{id}/company")
    public ResponseEntity<Optional<Company>> update(@Valid @PathVariable(name = "id") Long id,
                                                    @RequestParam(name = "company") Company company) {
        return ResponseEntity.ok(Optional.ofNullable(service.update(id, company)
                .orElseThrow(() -> new CompanyException("Failed to save company"))));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
    }

    @GetMapping("/name")
    public ResponseEntity<Company> findByName(@Valid @RequestParam(name = "name") String name) {

        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("/phone")
    public ResponseEntity<Company> findByPhoneNumber(@Valid @RequestParam(name = "phone") String phone) {
        return ResponseEntity.ok(service.findByPhoneNumber(phone));
    }

    @GetMapping("/names")
    public ResponseEntity<List<Company>> findACompanyByFirstBacks(@Valid @RequestParam(name = "name") String name) {
        return ResponseEntity.ok(Collections.singletonList((Company) service.findACompanyByFirstBacks(name)
                .orElseThrow(() -> new CompanyException("The requested company does not exist"))));
    }
}
