package com.example.crmprojecthibernategradle.company.service;


import com.example.crmprojecthibernategradle.company.model.Company;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
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
        return session.get(Company.class, id);
    }

    /**
     * @param company
     * @return
     */
    @Transactional
    public Company save(Company company) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(company);
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
    @Transactional
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Company.class, id));
    }

    /**
     * @param name
     */
    @Transactional(readOnly = true)
    public List<Company> findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return  session.createQuery("select c from Contact c where c.name = :name", Company.class).getResultList();
    }

    /**
     * @param phoneNumber
     */
    @Transactional(readOnly = true)
    public Company findByPhoneNumber(String phoneNumber) {
        Session session = sessionFactory.getCurrentSession();
       return session.get(Company.class, phoneNumber);
    }

    /**
     * @param name
     * @return
     */

    public List<Company> findByNameFirst(String name) {
        return null;
    }
}
