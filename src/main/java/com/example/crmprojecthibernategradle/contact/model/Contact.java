package com.example.crmprojecthibernategradle.contact.model;

import com.example.crmprojecthibernategradle.company.model.Company;
import com.example.crmprojecthibernategradle.task.model.Task;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
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
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime creation;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime update;
    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;
    @ToString.Exclude
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
}
