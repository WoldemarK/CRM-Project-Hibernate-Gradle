package com.example.CRMProject.task.repository;
import com.example.CRMProject.task.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TaskRepository {

    List<Task> findAll();
    Task findById(Long id);
    void save(Task task);
    void update(Long id, Task updatedTask);
    void delete(Long id);

    void findByName(String name);











}
