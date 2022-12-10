package com.example.crmprojecthibernategradle.task.service;

import com.example.crmprojecthibernategradle.task.model.Task;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {
    private final SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public Optional<List<Task>> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.createQuery("select t from Task t", Task.class).getResultList());
    }

    @Transactional(readOnly = true)
    public Optional<Task> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.get(Task.class, id));
    }

    @Transactional()
    public Optional<Task> save(Task task) {
        sessionFactory.getCurrentSession().saveOrUpdate(task);
        return Optional.of(task);
    }

    @Transactional(readOnly = true)
    public Optional<Task> update(Long id, Task updatedTask) {
        Session session = sessionFactory.getCurrentSession();
        Task task = session.get(Task.class, id);
        task.setId(updatedTask.getId());
        task.setName(updatedTask.getName());
        task.setExecutor(updatedTask.getExecutor());
        task.setCompany(updatedTask.getCompany());
        task.setContacts(updatedTask.getContacts());

        task.setCreation(updatedTask.getCreation());
        task.setUpdate(updatedTask.getUpdate());

        task.setCompany(updatedTask.getCompany());
        task.setContacts(updatedTask.getContacts());

        return Optional.of(task);
    }

    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Task.class, id));
    }

    @Transactional(readOnly = true)
    public Task findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        return (Task) session.createQuery("select t from Task t where t.name =name", Task.class);
    }
    @Transactional(readOnly = true)
    public Optional<List<Task>> findACompanyByFirstBacks(String name) {
        Session session = sessionFactory.getCurrentSession();
        return Optional
                .ofNullable(session.createQuery("select t from Task t where t.name like 'T'", Task.class)
                        .getResultList());
    }
}
