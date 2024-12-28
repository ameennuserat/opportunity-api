package com.example.opportunityapi.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

//    List<UserDto> findAllUser();
    UserDetailsService userDetailsService();
}
