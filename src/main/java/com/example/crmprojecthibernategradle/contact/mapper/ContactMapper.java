package com.example.crmprojecthibernategradle.contact.mapper;

import com.example.crmprojecthibernategradle.contact.DTO.ContactDTO;
import com.example.crmprojecthibernategradle.contact.model.Contact;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface ContactMapper {
    ContactDTO convertToContactDTO(Contact contact);

    Contact convertToContact(ContactDTO dto);
}
