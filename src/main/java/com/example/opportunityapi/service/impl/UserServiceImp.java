package com.example.opportunityapi.service.impl;

import com.example.opportunityapi.repository.UserRepo;
import com.example.opportunityapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepo userRepo;

    @Override
    public UserDetailsService userDetailsService() {
        return username -> userRepo.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("User Not Found")
        );
    }
}
