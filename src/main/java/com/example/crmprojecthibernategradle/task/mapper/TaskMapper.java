package com.example.crmprojecthibernategradle.task.mapper;

import com.example.crmprojecthibernategradle.task.DTO.TaskDTO;
import com.example.crmprojecthibernategradle.task.model.Task;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD)
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDTO convertToTaskDTO(Task task);

    Task convertToTask(TaskDTO dto);
}
