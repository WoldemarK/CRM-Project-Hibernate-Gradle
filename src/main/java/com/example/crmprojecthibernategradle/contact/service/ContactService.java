package com.example.crmprojecthibernategradle.contact.service;

import com.example.crmprojecthibernategradle.company.model.Company;
import com.example.crmprojecthibernategradle.contact.model.Contact;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final SessionFactory sessionFactory;


    @Transactional(readOnly = true)
    public Optional<List<Contact>> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return Optional.of(session.createQuery("select c from Contact  c", Contact.class).getResultList());
    }


    @Transactional(readOnly = true)
    public Optional<Contact> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.get(Contact.class, id));
    }


    @Transactional()
    public Optional<Contact> save(Contact contact) {
        Company company = contact.getCompany();
        List<Contact> contacts = company.getContacts();
        contacts.add(contact);
        company.setContacts(contacts);
        sessionFactory.getCurrentSession().saveOrUpdate(contact);
        return Optional.of(contact);
    }


//    @Transactional()
//    public Optional<Contact> update(Long id, Contact updatedContact) {
//        Session session = sessionFactory.getCurrentSession();
//
//        updatedContact = session.get(Contact.class, id);
//        contact.setId(updatedContact.getId());
//        contact.setName(updatedContact.getName());
//        contact.setEmail(updatedContact.getEmail());
//        contact.setPhoneNumber(updatedContact.getPhoneNumber());
//        contact.setDescriptions(updatedContact.getDescriptions());
//        contact.setPost(updatedContact.getPost());
//
//        contact.setCreation(updatedContact.getCreation());
//        contact.setUpdate(updatedContact.getUpdate());
//
//        contact.setCompany(updatedContact.getCompany());
//        contact.setTask(updatedContact.getTask());
//       session.saveOrUpdate(updatedContact);
//
//        return Optional.of(contact);
//    }


    @Transactional(readOnly = true)
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Contact.class, id));

    }

    @Transactional(readOnly = true)
    public Contact findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return (Contact) session.createQuery("select c from Contact c where c.name =name", Contact.class);
    }

    @Transactional(readOnly = true)
    public List<Contact> findByNames(List<Contact> contacts) {
        Session session = sessionFactory.getCurrentSession();
        List<String> searchByName = contacts
                .stream()
                .map(Contact::getName)
                .toList();
        return session.createQuery("select c from Contact c where c.name in :searchByName", Contact.class)
                .setParameter("searchByName", searchByName).getResultList();
    }


    @Transactional(readOnly = true)
    public Contact findByPhoneNumber(String phoneNumber) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Contact.class, phoneNumber);
    }


    @Transactional(readOnly = true)
    public Optional<List<Contact>> findByNameFirst(String name) {
        Session session = sessionFactory.getCurrentSession();
        return Optional
                .ofNullable(session.createQuery("select c from Contact c where c.name like 'T%'", Contact.class)
                        .getResultList());

    }


    @Transactional(readOnly = true)
    public List<Contact> findByNameCompany(List<Company> company) {
        Session session = sessionFactory.getCurrentSession();
        List<Long> ids = company.stream().map(Company::getId).toList();
        return session.createQuery("select c from Contact c where c.company.id in :ids", Contact.class)
                .setParameter("ids", ids)
                .getResultList();

    }
}
