package com.example.CRMProject.company.service;

import com.example.CRMProject.company.model.Company;
import com.example.CRMProject.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService implements CompanyRepository {

    private final SessionFactory sessionFactory;


    /**
     * @return
     */

    @Transactional(readOnly = true)
    public List<Company> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select c from Company c", Company.class).getResultList();
    }

    /**
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public Company findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Company.class,id);
    }

    /**
     * @param company
     * @return
     */
    @Transactional
    public Company save(Company company) {
        Session session = sessionFactory.getCurrentSession();
        session.save(company);
        return company;
    }

    /**
     * @param id
     * @param updatedCompany
     */

    public void update(Long id, Company updatedCompany) {

    }

    /**
     * @param id
     */

    public void delete(Long id) {

    }

    /**
     * @param name
     */

    public void findByName(String name) {

    }

    /**
     * @param phoneNumber
     */

    public void findByPhoneNumber(String phoneNumber) {

    }

    /**
     * @param name
     * @return
     */

    public List<Company> findByNameFirst(String name) {
        return null;
    }
}
