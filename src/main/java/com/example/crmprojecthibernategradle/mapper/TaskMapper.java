package com.example.crmprojecthibernategradle.mapper;

import com.example.crmprojecthibernategradle.dto.TaskDTO;
import com.example.crmprojecthibernategradle.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    @Mapping(source = "company.id", target = "companyId")
    @Mapping(source = "contact.id", target = "contactId")
    /**
     * нужно ли дополнительно перегонять тут если в классе уже указанны данные?
     *    @UpdateTimestamp
     *     @Temporal(TemporalType.TIMESTAMP)
     *     @DateTimeFormat(pattern = "dd/MM/yyyy")
     */
    @Mapping(source = "creation", target = "creation", dateFormat = "dd/MM/yyyy")
    @Mapping(source = "update", target = "update", dateFormat = "dd/MM/yyyy")
    TaskDTO convertToTaskDTO(Task task);


    @Mapping(source = "companyId", target = "company.id")
    @Mapping(source = "contactId", target = "contact.id")
    @Mapping(source = "creation", target = "creation", dateFormat = "dd/MM/yyyy")
    @Mapping(source = "update", target = "update", dateFormat = "dd/MM/yyyy")
    Task convertToTask(TaskDTO dto);

    @Mapping(source = "companyId", target = "company.id")
    @Mapping(source = "contactId", target = "contact.id")
    @Mapping(source = "creation", target = "creation", dateFormat = "dd/MM/yyyy")
    @Mapping(source = "update", target = "update", dateFormat = "dd/MM/yyyy")
    void updateFromDto(TaskDTO taskDTO, @MappingTarget Task task);
}
