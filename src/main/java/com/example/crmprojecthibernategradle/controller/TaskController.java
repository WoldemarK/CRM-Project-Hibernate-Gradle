package com.example.crmprojecthibernategradle.controller;

import com.example.crmprojecthibernategradle.dto.TaskDTO;
import com.example.crmprojecthibernategradle.exception.TaskException;
import com.example.crmprojecthibernategradle.model.Task;
import com.example.crmprojecthibernategradle.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @GetMapping("/all")
    public ResponseEntity<Optional<List<Task>>> getAll() {
        return ResponseEntity.ok(Optional.ofNullable(service.getAll()));
    }

    @PostMapping("/save")
    public ResponseEntity<TaskDTO> save(@RequestBody Task task) {
        return ResponseEntity.ok(service.convertToTaskDTO(task));
    }
    @PostMapping("/newDto")
    public ResponseEntity<TaskDTO>creationAndPreservation(@Valid @RequestBody TaskDTO taskDTO){
        return ResponseEntity.ok(service.creationAndPreservation(taskDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@Valid @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(service.getId(id));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@Valid @PathVariable(name = "id") Long id) {
        if (id == null)
            throw new TaskException(String.format("ID %d does not exist ", id));
        service.deleteById(id);
    }

    @GetMapping("/name")
    public ResponseEntity<Optional<Task>> findByName(@Valid @RequestParam(name = "name") String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @GetMapping("/names")
    public ResponseEntity<Optional<List<Task>>> findACompanyByFirstBacks(@Valid @RequestParam(name = "name") String name) {
        return ResponseEntity.ok(service.findACompanyByFirstBacks(name));
    }
    @PutMapping
    public TaskDTO update(@Valid @RequestBody TaskDTO taskDTO){
        return service.update(taskDTO);
    }
}
