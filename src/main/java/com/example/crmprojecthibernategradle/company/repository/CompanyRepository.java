package com.example.CRMProject.company.repository;

import com.example.CRMProject.company.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository  {
    List<Company> findAll();
    //Company findById(Long id);
    Company save(Company company);

//    void update(Long id, Company updatedCompany);
//    void delete(Long id);
//    void findByName(String name);
//    void findByPhoneNumber(String phoneNumber);
//    List<Company> findByNameFirst(String name);

  //  List<Company> findAll(List<Company> selectCFromCompanyC);

}
