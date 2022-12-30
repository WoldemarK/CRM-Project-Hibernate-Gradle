package com.example.crmprojecthibernategradle.dto;

import com.example.crmprojecthibernategradle.model.Company;
import com.example.crmprojecthibernategradle.model.Task;
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
