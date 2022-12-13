package com.example.crmprojecthibernategradle.company.model;


import com.example.crmprojecthibernategradle.contact.model.Contact;
import com.example.crmprojecthibernategradle.task.model.Task;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@ToString
@Table(name = "Company")
public class Company  {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @Column(name = "name")
    private String name;
    @Email
    @Column(name = "email")
    @NotEmpty(message = "Email should be empty ")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "descriptions")
    private String descriptions;
    @Column(name = "type")
    private String type;
    @Column(name = "website")
    private String website;
    @Column(name = "inn")
    private Long INN;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime creation;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime update;
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Contact> contacts;
    @ToString.Exclude
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Task> task;

    public void addContact(Contact c) {
        if (contacts == null)
            this.contacts = new ArrayList<>();
        this.contacts.add(c);
        c.setCompany(this);
    }

    public void addTask(Task t) {
        if (task == null)
            this.task = new ArrayList<>();
        this.task.add(t);
        t.setCompany(this);
    }

    public Company(Long id, String name, String email,
                   String phoneNumber, String descriptions,
                   String type, String website, Long INN) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.descriptions = descriptions;
        this.type = type;
        this.website = website;
        this.INN = INN;

        LocalDateTime date = LocalDateTime.now();
        this.creation = date;
        this.update = date;
    }

    public Company() {
    }
}
