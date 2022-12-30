package com.example.crmprojecthibernategradle.security_modul.security;

import com.example.crmprojecthibernategradle.security_modul.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class AuthProviderImpl implements AuthenticationProvider {
    private final UserDetailsServiceImpl service;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();

        UserDetailsImpl userDetailsImpl = service.loadUserByUsername(name);

        String password = authentication.getCredentials().toString();

        if (!password.equals(userDetailsImpl.getPassword())) {
            throw new BadCredentialsException("Incorrect password");
        }
        return new UsernamePasswordAuthenticationToken(userDetailsImpl, password,
                Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
