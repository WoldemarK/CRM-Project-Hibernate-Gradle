package com.example.crmprojecthibernategradle.security_modul.repository;

import com.example.crmprojecthibernategradle.security_modul.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
