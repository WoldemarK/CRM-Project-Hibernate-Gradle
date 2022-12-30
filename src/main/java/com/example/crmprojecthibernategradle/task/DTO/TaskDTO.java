package com.example.crmprojecthibernategradle.task.DTO;

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
    private long companyId;
    private long contactId;

}
