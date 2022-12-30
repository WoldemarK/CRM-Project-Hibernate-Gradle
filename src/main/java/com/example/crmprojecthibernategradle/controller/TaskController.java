package com.example.crmprojecthibernategradle.controller;

import com.example.crmprojecthibernategradle.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

//    @GetMapping("/all")
//    public ResponseEntity<Optional<List<Task>>> getAll() {
//        return ResponseEntity.ok(service.findAll());
//    }
//    @PostMapping("/save")
//    public ResponseEntity<Task> save(@RequestBody Task task) {
//        return ResponseEntity.ok(service.save(task)
//                .orElseThrow(() ->
//                        new CompanyException("An error occurred while saving, check the spelling of the input")));
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Task>> findById(@Valid @PathVariable(name = "id") Long id) {
//        return ResponseEntity.ok(Optional.ofNullable(service.findById(id)
//                .orElseThrow(() -> new CompanyException("The requested task does not exist" + id))));
//
//    }
//    @DeleteMapping("/delete/{id}")
//    public void delete(@PathVariable(name = "id") Long id) {
//        service.delete(id);
//    }
//    @GetMapping("/name")
//    public ResponseEntity<Task> findByName(@Valid @RequestParam(name = "name") String name) {
//        return ResponseEntity.ok(service.findByName(name));
//    }
//    @GetMapping("/names")
//    public ResponseEntity<List<Task>> findACompanyByFirstBacks(@Valid @RequestParam(name = "name") String name) {
//        return ResponseEntity.ok(Collections.singletonList((Task) service.findACompanyByFirstBacks(name)
//                .orElseThrow(() -> new CompanyException("The requested company does not exist"))));
//    }
}
