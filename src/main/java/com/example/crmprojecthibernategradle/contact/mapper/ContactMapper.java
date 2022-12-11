package com.example.crmprojecthibernategradle.contact.mapper;

import com.example.crmprojecthibernategradle.contact.DTO.ContactDTO;
import com.example.crmprojecthibernategradle.contact.model.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactMapper {
    ContactMapper INSTANCE = Mappers.getMapper(ContactMapper.class);

    ContactDTO convertToContactDTO(Contact contact);

    Contact convertToContact(ContactDTO dto);
}
