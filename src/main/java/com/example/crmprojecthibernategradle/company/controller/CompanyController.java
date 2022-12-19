package com.example.crmprojecthibernategradle.company.controller;

import com.example.crmprojecthibernategradle.company.DTO.CompanyDTO;
import com.example.crmprojecthibernategradle.company.exception.CompanyException;
import com.example.crmprojecthibernategradle.company.mapper.CompanyMapper;
import com.example.crmprojecthibernategradle.company.model.Company;
import com.example.crmprojecthibernategradle.company.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService service;
    private final CompanyMapper companyMapper;

    @GetMapping("/all")
    public ResponseEntity<Optional<List<Company>>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Company> saveCompanyAndContact(@RequestBody Company company) {
        return ResponseEntity.ok(service.saveCompanyAndContact(company)
                .orElseThrow(() ->
                        new CompanyException("An error occurred while saving, check the spelling of the input")));
    }
    @PostMapping("/saveCompany")
    public ResponseEntity<Company> saveCompany(@RequestBody Company company) {
        return ResponseEntity.ok(service.saveCompany(company)
                .orElseThrow(() ->
                        new CompanyException("An error occurred while saving, check the spelling of the input")));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CompanyDTO>> findById(@Valid @PathVariable(name = "id") Long id) {
        Optional<Company> company = service.findById(id);
        return company
                .map(c -> ResponseEntity.ok(Optional.ofNullable(companyMapper.convertToCompanyDTO(c))))
                .orElseThrow(() -> new CompanyException("The requested company does not exist" + id));


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
