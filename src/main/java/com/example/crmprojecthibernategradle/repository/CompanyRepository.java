package com.example.crmprojecthibernategradle.repository;

import com.example.crmprojecthibernategradle.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
