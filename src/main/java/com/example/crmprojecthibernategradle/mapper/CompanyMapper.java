package com.example.crmprojecthibernategradle.mapper;

import com.example.crmprojecthibernategradle.dto.CompanyDTO;
import com.example.crmprojecthibernategradle.model.Company;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyDTO convertToCompanyDTO(Company company);

    Company convertToCompany(CompanyDTO dto);
}
