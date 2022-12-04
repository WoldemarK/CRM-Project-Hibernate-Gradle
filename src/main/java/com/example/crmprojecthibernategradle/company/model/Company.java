package com.example.CRMProject.company.model;

import com.example.CRMProject.contact.model.Contact;
import com.example.CRMProject.task.model.Task;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import org.hibernate.annotations.Cascade;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Contact> contacts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Task>task;

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


    @Column(name = "creation")
    private LocalDateTime creation;

    @Column(name = "update")
    private LocalDateTime update;

    public Company() {

    }

    public Company(Long id, String name, String email, String phoneNumber,
                   String descriptions, String type, String website) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.descriptions = descriptions;
        this.type = type;
        this.website = website;

        LocalDateTime date = LocalDateTime.now();
        this.creation = date;
        this.update = date;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Task> getTask() {
        return task;
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Long getINN() {
        return INN;
    }

    public void setINN(Long INN) {
        this.INN = INN;
    }

    public LocalDateTime getCreation() {
        return creation;
    }

    public void setCreation(LocalDateTime creation) {
        this.creation = creation;
    }

    public LocalDateTime getUpdate() {
        return update;
    }

    public void setUpdate(LocalDateTime update) {
        this.update = update;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", type='" + type + '\'' +
                ", website='" + website + '\'' +
                ", INN=" + INN +
                ", creation=" + creation +
                ", update=" + update +
                '}';
    }
}
