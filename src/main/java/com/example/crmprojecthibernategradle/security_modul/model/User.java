package com.example.crmprojecthibernategradle.security_modul.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name must not be empty")
    @Size(min = 2, max = 100, message = "The name must then be 2 characters long")
    @Column(name = "user_name")
    private String username;
    @Column(name = "password")
    private String password;

    @ManyToMany
    private Set<Role> roles;

    public User(String username) {
        this.username = username;

    }
}
