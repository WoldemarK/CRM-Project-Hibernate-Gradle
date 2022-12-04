package com.example.CRMProject.contact.model;

import com.example.CRMProject.company.model.Company;
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
@Table(name = "contact")
public class Contact {

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
    @Size(min = 2, message = "length must be between characters")
    @Column(name = "post")
    private String post;

    @Column(name = "creation", insertable = false, updatable = false)
    private LocalDateTime creation;
    @Column(name = "creation", insertable = false, updatable = false)
    private LocalDateTime update;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contacts")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Task> task;

    public void addTask(Task t) {
        if (task == null)
            this.task = new ArrayList<>();
        this.task.add(t);
        t.setContacts(this);
    }

    public Contact(String name, String email, String descriptions, String post) {
        this.name = name;
        this.email = email;

        this.descriptions = descriptions;
        this.post = post;

        LocalDateTime date = LocalDateTime.now();
        this.creation = date;
        this.update = date;
    }

    public Contact() {

    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
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
        return "Contact{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", post='" + post + '\'' +
                ", creation=" + creation +
                ", update=" + update +
                '}';
    }
}
