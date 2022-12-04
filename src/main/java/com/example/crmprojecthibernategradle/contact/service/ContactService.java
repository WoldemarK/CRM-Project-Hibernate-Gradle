package com.example.crmprojecthibernategradle.contact.service;

import com.example.crmprojecthibernategradle.company.model.Company;
import com.example.crmprojecthibernategradle.contact.model.Contact;
import com.example.crmprojecthibernategradle.contact.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService implements ContactRepository {
    private final SessionFactory sessionFactory;


    /**
     * Показать все контакты
     *
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<Contact> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Contact c", Contact.class).getResultList();
    }

    /**
     * Поиск контакта по ID
     *
     * @param id
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public Contact findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Contact.class, id);
    }

    /**
     * Сохранение контакта
     *
     * @param contact
     */
    @Override
    @Transactional()
    public Contact save(Contact contact) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(contact);
        return contact;
    }

    /**
     * Обновление контакта
     *
     * @param id
     * @param updatedContact
     */
    @Override
    @Transactional(readOnly = true)
    public void update(Long id, Contact updatedContact) {
        Session session = sessionFactory.getCurrentSession();

        Contact contact = session.get(Contact.class, id);
        contact.setId(updatedContact.getId());
        contact.setName(updatedContact.getName());
        contact.setEmail(updatedContact.getEmail());
        contact.setPhoneNumber(updatedContact.getPhoneNumber());
        contact.setDescriptions(updatedContact.getDescriptions());


    }

    /**
     * Удаление Контакта
     *
     * @param id
     */
    @Override
    @Transactional(readOnly = true)
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Contact.class, id));
        System.out.println("Контакт с ID: " + id + " уделен");

    }

    /**
     * Поиск контакта по имени
     *
     * @param name
     */
    @Override
    @Transactional(readOnly = true)
    public void findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("select  c from Contact c where c.name=name", Contact.class);
    }

    /**
     * Поиск контакта по номеру телефона
     *
     * @param phoneNumber
     */
    @Override
    @Transactional(readOnly = true)
    public void findByPhoneNumber(String phoneNumber) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("select  c from Contact c where c.phoneNumber=phoneNumber", Contact.class);
    }

    /**
     * Поиск контакта по первым символом
     *
     * @param name
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<Contact> findByNameFirst(String name) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Contact c where c.name like 'T%'", Contact.class).getResultList();
    }

    /**
     * Поиск контактов по компании
     *
     * @param company
     */
   // @Override
    @Transactional(readOnly = true)
    public List<Contact> findByNameCompany(List<Company> company) {
        Session session = sessionFactory.getCurrentSession();
        List<Long> ids = company.stream().map(Company::getId).toList();
        return session.createQuery("select c from Contact c where c.company.id in :ids", Contact.class)
                .setParameter("ids", ids)
                .getResultList();

    }
}
