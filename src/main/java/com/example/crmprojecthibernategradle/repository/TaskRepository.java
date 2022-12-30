package com.example.crmprojecthibernategradle.repository;

import com.example.crmprojecthibernategradle.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByName(String name);
    List<Task>findByNameStartingWith(String name);

}
