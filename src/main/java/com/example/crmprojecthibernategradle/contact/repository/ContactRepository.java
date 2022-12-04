package com.example.CRMProject.contact.repository;

import com.example.CRMProject.company.model.Company;
import com.example.CRMProject.contact.model.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ContactRepository {
    // @Query("select c from Contact c")
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
