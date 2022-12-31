package com.example.crmprojecthibernategradle.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Task")
public class Task {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name should not be empty")
    @Column(name = "name", length = 128, nullable = false)
    @Size(min = 2, max = 128, message = "Name should be between 2 and 30 characters")
    private String name;
    @Column(name = "descriptions", length = 4068, nullable = false)
    private String descriptions;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime creation;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime update;
    @Column(name = "executor")
    private String executor;
    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;
    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

    public Task(String name, String descriptions, String executor) {
        this.name = name;
        this.descriptions = descriptions;
        this.executor = executor;

        LocalDateTime date = LocalDateTime.now();
        this.creation = date;
        this.update = date;
    }

    public Task() {
    }
}
