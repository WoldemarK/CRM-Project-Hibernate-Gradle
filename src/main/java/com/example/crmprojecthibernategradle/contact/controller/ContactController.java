package com.example.CRMProject.contact.controller;

import com.example.CRMProject.company.model.Company;
import com.example.CRMProject.contact.model.Contact;
import com.example.CRMProject.contact.service.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService service;
    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getAllContacts() {
        return ResponseEntity.ok(service.findAll());
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Contact> getId(@Valid @PathVariable(name = "id") Long id) {
//        return ResponseEntity.ok(service.findById(id));
//    }

    @PostMapping
    public ResponseEntity<Contact> save(@RequestBody Contact contacts) {
        return ResponseEntity.ok(service.save(contacts));
    }

//    @PatchMapping("/{id}/contact")
//    public void update(@Valid @PathVariable(name = "id") Long id, @RequestBody Contact contact) {
//        service.update(id, contact);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable(name = "id") Long id) {
//        service.delete(id);
//    }
//
//    @GetMapping("/name")
//    public void getName(@RequestParam(name = "name") String name) {
//        service.findByName(name);
//    }
//
//    @GetMapping("/phoneNumber")
//    public void getPhone(@RequestParam(name = "phoneNumber") String phoneNumber) {
//        service.findByName(phoneNumber);
//    }
//
//    @GetMapping("/firstName")
//    public ResponseEntity<List<Contact>> first(@Valid @RequestParam(name = "firstName") String firstName) {
//        return ResponseEntity.ok(service.findByNameFirst(firstName));
    }
//    @GetMapping("/findBy")
//    public ResponseEntity<List<Company>>  findByNameCompany(@RequestParam(name = " findByN") List<Company> findBy){
//
//        return service.findByNameCompany(findBy);
//    }

