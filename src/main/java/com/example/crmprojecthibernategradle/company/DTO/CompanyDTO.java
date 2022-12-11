package com.example.crmprojecthibernategradle.company.DTO;

import com.example.crmprojecthibernategradle.contact.model.Contact;
import com.example.crmprojecthibernategradle.task.model.Task;
import lombok.Data;

import java.time.LocalDateTime;

import java.util.List;
@Data
public class CompanyDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String descriptions;
    private String type;
    private String website;
    private Long INN;
    private LocalDateTime creation;
    private LocalDateTime update;
    private List<Contact> contacts;
    private List<Task> task;


}
