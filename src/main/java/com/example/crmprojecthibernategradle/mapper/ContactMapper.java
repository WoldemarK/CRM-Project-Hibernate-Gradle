package com.example.crmprojecthibernategradle.mapper;

import com.example.crmprojecthibernategradle.dto.ContactDTO;
import com.example.crmprojecthibernategradle.model.Contact;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface ContactMapper {
    ContactDTO convertToContactDTO(Contact contact);

    Contact convertToContact(ContactDTO dto);
}
