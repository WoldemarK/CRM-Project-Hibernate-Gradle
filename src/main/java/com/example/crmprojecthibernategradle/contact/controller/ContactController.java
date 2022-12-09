package com.example.crmprojecthibernategradle.contact.controller;

import com.example.crmprojecthibernategradle.company.exception.CompanyException;
import com.example.crmprojecthibernategradle.contact.exception.ContactException;
import com.example.crmprojecthibernategradle.contact.model.Contact;
import com.example.crmprojecthibernategradle.contact.service.ContactService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contact")
@RequiredArgsConstructor
public class ContactController {
    private final ContactService service;

    @GetMapping("/all")
    public ResponseEntity<Optional<List<Contact>>> getAllContacts() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Contact> save(@RequestBody Contact contacts) {
        return ResponseEntity.ok(service.save(contacts)
                .orElseThrow(() -> new ContactException("An error occurred while saving, check the spelling of the input")));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Contact>> getId(@Valid @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(Optional.ofNullable(service.findById(id)
                .orElseThrow(() -> new ContactException("The requested contact does not exist" + id))));
    }

    @PutMapping("/{id}/contact")
    public ResponseEntity<Optional<Contact>> update(@Valid @PathVariable(name = "id") Long id,
                                                    @RequestParam(name = "contact") Contact contact) {
        return ResponseEntity.ok(Optional.ofNullable(service.update(id, contact)
                .orElseThrow(() -> new CompanyException("Failed to save contact"))));
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
    }
    @GetMapping("/name")
    public ResponseEntity<Contact> findByName(@Valid @RequestParam(name = "name") String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("/phone")
    public ResponseEntity<Contact> findByPhoneNumber(@Valid @RequestParam(name = "phone") String phone) {
        return ResponseEntity.ok(service.findByPhoneNumber(phone));
    }

    @GetMapping("/names")
    public ResponseEntity<List<Contact>> findAContactByFirstBacks(@Valid @RequestParam(name = "name") String name) {
        return ResponseEntity.ok(Collections.singletonList((Contact) service.findByNameFirst(name)
                .orElseThrow(() -> new ContactException("The requested contact does not exist"))));
    }
}

