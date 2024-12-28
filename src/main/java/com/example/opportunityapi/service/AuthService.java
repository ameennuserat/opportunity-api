package com.example.opportunityapi.service;

import com.example.opportunityapi.model.dto.*;
import org.springframework.transaction.annotation.Transactional;

public interface AuthService {

    @Transactional
    UserRegisterDto register(UserRegisterDto dto);

    UserDto login(UserLoginDto dto);

    UserTokenDto refresh(UserRefreshTokenDto dto);

//    void verificationAccount(UserVerificationDto dto);

}
