package com.example.crmprojecthibernategradle.repository;

import com.example.crmprojecthibernategradle.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {


}
