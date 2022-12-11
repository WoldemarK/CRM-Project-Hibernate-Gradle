package com.example.crmprojecthibernategradle.task.DTO;

import com.example.crmprojecthibernategradle.company.model.Company;
import com.example.crmprojecthibernategradle.contact.model.Contact;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDTO {

    private Long id;


    private String name;

    private String descriptions;

    private LocalDateTime creation;

    private LocalDateTime update;

    private String executor;

    private Company company;

    private Contact contacts;



}
