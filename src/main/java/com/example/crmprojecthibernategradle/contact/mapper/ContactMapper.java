package com.example.crmprojecthibernategradle.contact.mapper;

import com.example.crmprojecthibernategradle.contact.DTO.ContactDTO;
import com.example.crmprojecthibernategradle.contact.model.Contact;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    ContactDTO convertToContactDTO(Contact contact);

    Contact convertToContact(ContactDTO dto);
}
