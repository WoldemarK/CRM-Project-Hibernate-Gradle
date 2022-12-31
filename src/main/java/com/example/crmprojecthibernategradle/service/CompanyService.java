package com.example.crmprojecthibernategradle.service;


import com.example.crmprojecthibernategradle.model.Company;
import com.example.crmprojecthibernategradle.model.Contact;
import com.example.crmprojecthibernategradle.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CompanyService {
    private final SessionFactory sessionFactory;

    private final CompanyRepository repository;

    @Transactional(readOnly = true)
    public Optional<List<Company>> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return Optional
                .ofNullable(session.createQuery("select c from Company c", Company.class).getResultList());
    }


    @Transactional(readOnly = true)
    public Company findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Company.class, id);
    }


    @Transactional
    public Optional<Company> saveCompanyAndContact(Company company) {
        for (Contact contact : company.getContacts()){
            contact.setCompany(company);
        }
        sessionFactory.getCurrentSession().saveOrUpdate(company);
        return Optional.of(company);
    }
    @Transactional
    public Optional<Company> saveCompany(Company company){
        sessionFactory.getCurrentSession().saveOrUpdate(company);
        return Optional.of(company);
    }

    @Transactional
    public Optional<Company> update(Long id, Company updatedCompany) {
        Session session = sessionFactory.getCurrentSession();

        Company company = session.get(Company.class, id);
        company.setId(updatedCompany.getId());
        company.setName(updatedCompany.getName());
        company.setEmail(updatedCompany.getEmail());
        company.setPhoneNumber(updatedCompany.getPhoneNumber());
        company.setDescriptions(updatedCompany.getDescriptions());
        company.setType(updatedCompany.getType());
        company.setWebsite(updatedCompany.getWebsite());
        company.setINN(updatedCompany.getINN());

        company.setCreation(updatedCompany.getCreation());
        company.setUpdate(updatedCompany.getUpdate());

        company.setContacts(updatedCompany.getContacts());
        company.setTask(updatedCompany.getTask());

        return Optional.of(company);
    }

    @Transactional
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Company.class, id));

    }


    @Transactional(readOnly = true)
    public Company findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return (Company) session.createQuery("select c from Company c where c.name =name", Company.class);
    }

    /**
     * Alternative search by name
     *
     * @param companies
     * @return
     */
    @Transactional(readOnly = true)
    public List<Company> findByNames(List<Company> companies) {
        Session session = sessionFactory.getCurrentSession();
        List<String> searchByName = companies
                .stream()
                .map(Company::getName)
                .toList();
        return session.createQuery("select c from Company c where c.name in :searchByName", Company.class)
                .setParameter("searchByName", searchByName).getResultList();
    }

    @Transactional(readOnly = true)
    public Company findByPhoneNumber(String phoneNumber) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Company.class, phoneNumber);
    }

    /**
     * Search by initial letters
     *
     * @param name
     * @return
     */
    @Transactional(readOnly = true)
    public Optional<List<Company>> findACompanyByFirstBacks(String name) {
        Session session = sessionFactory.getCurrentSession();
        return Optional
                .ofNullable(session.createQuery("select c from Company c where c.name like 'T'", Company.class)
                        .getResultList());
    }


}
