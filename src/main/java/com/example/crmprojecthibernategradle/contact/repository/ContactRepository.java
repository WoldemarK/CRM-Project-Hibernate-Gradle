package com.example.crmprojecthibernategradle.contact.repository;

import com.example.crmprojecthibernategradle.contact.model.Contact;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContactRepository {
    List<Contact> findAll();



    Contact findById(Long id);

    Contact save(Contact contact);

    void update(Long id, Contact updatedContact);

    void delete(Long id);

    void findByName(String name);

    void findByPhoneNumber(String phoneNumber);

    List<Contact> findByNameFirst(String name);

    //List<Contact> findByNameCompany(List<Company> company);


}
