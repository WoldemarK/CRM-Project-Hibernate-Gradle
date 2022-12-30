package com.example.crmprojecthibernategradle.dto;

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
    /**
     * почему не прописываем класс а только
     *     private long companyId;
     *     private long contactId;
     */
    private long companyId;
    private long contactId;

}
