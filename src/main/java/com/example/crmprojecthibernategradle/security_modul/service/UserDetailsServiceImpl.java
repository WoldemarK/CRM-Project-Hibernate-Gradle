//package com.example.crmprojecthibernategradle.security_modul.service;
//
//import com.example.crmprojecthibernategradle.security_modul.model.User;
//import com.example.crmprojecthibernategradle.security_modul.repository.UserRepository;
//import com.example.crmprojecthibernategradle.security_modul.security.UserDetailsImpl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class UserDetailsServiceImpl implements UserDetailsService {
//    private final UserRepository repository;
//
//    @Override
//    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> person = Optional.ofNullable(repository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found!")));
//
//        return new UserDetailsImpl(person.get());
//    }
//}
