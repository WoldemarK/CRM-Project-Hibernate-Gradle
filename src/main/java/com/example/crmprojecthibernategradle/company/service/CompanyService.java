package com.example.crmprojecthibernategradle.company.service;


import com.example.crmprojecthibernategradle.company.model.Company;
import com.example.crmprojecthibernategradle.contact.model.Contact;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyService {
    private final SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(Company.class);

    @Transactional(readOnly = true)
    public Optional<List<Company>> findAll() {
        Session session = sessionFactory.getCurrentSession();
        logger.info("Getting all companies");
        return Optional.ofNullable(session.createQuery("select c from Company c", Company.class).getResultList());
    }


    @Transactional(readOnly = true)
    public Optional<Company> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        logger.info("Getting a company by ID " + id);
        return Optional.ofNullable(session.get(Company.class, id));
    }


    @Transactional
    public Optional<Company> save(Company company) {
        sessionFactory.getCurrentSession().saveOrUpdate(company);
        logger.info("Company saved with id: " + company.getId());
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

        company.setCreation(updatedCompany.setCreation(LocalDateTime.now()));
        company.setUpdate(updatedCompany.getUpdate());

        logger.info("Company update was successful");

        return Optional.of(company);
    }

    @Transactional
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Company.class, id));
        logger.info("Company deleted with id: " + id);
    }


    //    @Transactional(readOnly = true)
//    public List<Company> findByName(List<Company> companies) {
//        Session session = sessionFactory.getCurrentSession();
//        List<Long> searchByName = companies
//                .stream()
//                .map(Company::getId)
//                .toList();
//        return session.createQuery("select c from Company c where c.name in :searchByName", Company.class)
//                .setParameter("searchByName", searchByName).getResultList();
//    }
    @Transactional(readOnly = true)
    public Company findByName(String name) {
        Session session = sessionFactory.getCurrentSession();

        return (Company) session.createQuery("select c from Company c where c.name =name");
    }

    @Transactional(readOnly = true)
    public Company findByPhoneNumber(String phoneNumber) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Company.class, phoneNumber);
    }

    @Transactional(readOnly = true)
    public Optional<List<Company>> findACompanyByFirstBacks(String name) {
        Session session = sessionFactory.getCurrentSession();
        return Optional
                .ofNullable(session.createQuery("select c from Company c where c.name like 'T'", Company.class)
                        .getResultList());
    }
    /**
     * search by task in company
     * search for a person responsible for tasks
     */
}
