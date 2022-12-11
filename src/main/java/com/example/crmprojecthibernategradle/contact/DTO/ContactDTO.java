package com.example.crmprojecthibernategradle.contact.DTO;

import com.example.crmprojecthibernategradle.company.model.Company;
import com.example.crmprojecthibernategradle.task.model.Task;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class ContactDTO {

    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private String descriptions;

    private String post;

    private LocalDateTime creation;

    private LocalDateTime update;

    private Company company;

    private List<Task> task;

}
