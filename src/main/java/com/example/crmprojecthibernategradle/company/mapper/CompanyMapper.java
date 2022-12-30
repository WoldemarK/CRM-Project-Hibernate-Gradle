package com.example.crmprojecthibernategradle.company.mapper;

import com.example.crmprojecthibernategradle.company.DTO.CompanyDTO;
import com.example.crmprojecthibernategradle.company.model.Company;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface CompanyMapper {
    CompanyDTO convertToCompanyDTO(Company company);

    Company convertToCompany(CompanyDTO dto);
}
