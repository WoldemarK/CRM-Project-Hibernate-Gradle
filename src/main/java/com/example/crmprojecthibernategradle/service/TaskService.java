package com.example.crmprojecthibernategradle.service;

import com.example.crmprojecthibernategradle.dto.TaskDTO;
import com.example.crmprojecthibernategradle.exception.TaskException;
import com.example.crmprojecthibernategradle.mapper.TaskMapper;
import com.example.crmprojecthibernategradle.model.Task;
import com.example.crmprojecthibernategradle.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TaskService {

    //private final SessionFactory sessionFactory;
    private final TaskRepository repository;
    private final TaskMapper taskMapper;
    private final CompanyService companyService;
    private final ContactService contactService;

    public List<Task> getAll() {
        return repository.findAll();
    }

    public Task getId(Long id) {
        Optional<Task> optionalTask = repository.findById(id);
        return optionalTask.orElseThrow(() ->
                new TaskException(String.format("This ID %d does not exist ", id)));
    }


    @Transactional
    public TaskDTO creationAndPreservation(TaskDTO taskDTO) {
        Task task = taskMapper.convertToTask(taskDTO);
        task.setCompany(companyService.findById(taskDTO.getCompanyId()));
        task.setContact(contactService.findById(taskDTO.getContactId()));
        return convertToTaskDTO(task);
    }

    @Transactional
    public TaskDTO convertToTaskDTO(Task task) {
        task = repository.save(task);
        return taskMapper.convertToTaskDTO(task);
    }


    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Optional<Task> findByName(String name) {
        Optional<Task> task = Optional.ofNullable(repository.findByName(name));
        return Optional.ofNullable(task.orElseThrow(() ->
                new TaskException("The requested name does not exist")));
    }


    public Optional<List<Task>> findACompanyByFirstBacks(String name) {
        Optional<List<Task>> taskList = Optional.ofNullable(repository.findByNameStartingWith(name));
        return Optional.ofNullable(taskList.orElseThrow(() ->
                new TaskException("Requested names not found")));
    }

    @Transactional
    public TaskDTO update(TaskDTO taskDTO) {
        return repository.findById(taskDTO.getId())
                .map(task -> {
                    taskMapper.updateFromDto(taskDTO, task);
                    return convertToTaskDTO(task);
                })
                .orElseThrow(() ->
                        new TaskException(String.format("Task with id %d does not exist.", taskDTO.getId())));
    }

//    public Optional<List<Task>> findACompanyByFirstBacks(String name) {
//        Session session = sessionFactory.getCurrentSession();
//        return Optional
//                .ofNullable(session.createQuery("select t from Task t where t.name like 'T'", Task.class)
//                        .getResultList());
//    }
//    public Task findByName(String name) {
//        Session session = sessionFactory.getCurrentSession();
//        return (Task) session.createQuery("select t from Task t where t.name =name", Task.class);
//    }
//    @Transactional
//    public void delete(Long id) {
//        Session session = sessionFactory.getCurrentSession();
//        session.remove(session.get(Task.class, id));
//    }
    //    public Optional<Task> findById(Long id) {
    //    Session session = sessionFactory.getCurrentSession();
    //    return Optional.ofNullable(session.get(Task.class, id));
    //    }

    //    public Optional<List<Task>> findAll() {
    //    Session session = sessionFactory.getCurrentSession();
    //    return Optional.ofNullable(session.createQuery("select t from Task t", Task.class).getResultList());
    //    }

    //    @Transactional
    //    public Optional<Task> save(Task task) {
    //    sessionFactory.getCurrentSession().saveOrUpdate(task);
    //    return Optional.of(task);
    //    }

    //    @Transactional
    //    public Optional<Task> update(Long id, Task updatedTask) {
    //    Session session = sessionFactory.getCurrentSession();
    //    Task task = session.get(Task.class, id);
    //    task.setId(updatedTask.getId());
    //    task.setName(updatedTask.getName());
    //    task.setExecutor(updatedTask.getExecutor());
    //    task.setCompany(updatedTask.getCompany());
    //    task.setContact(updatedTask.getContact());
    //
    //    task.setCreation(updatedTask.getCreation());
    //    task.setUpdate(updatedTask.getUpdate());
    //
    //    task.setCompany(updatedTask.getCompany());
    //    task.setContact(updatedTask.getContact());
    //
    //    return Optional.of(task);
    //    }
}


