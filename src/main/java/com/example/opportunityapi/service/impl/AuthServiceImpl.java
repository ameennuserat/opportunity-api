package com.example.opportunityapi.service.impl;

import com.example.opportunityapi.config.JwtService;
import com.example.opportunityapi.model.dto.*;
import com.example.opportunityapi.model.entity.CompanyProfile;
import com.example.opportunityapi.model.entity.User;
import com.example.opportunityapi.model.entity.UserProfile;
import com.example.opportunityapi.model.enums.Role;
import com.example.opportunityapi.model.mapper.UserMapper;
import com.example.opportunityapi.repository.CompanyProfileRepo;
import com.example.opportunityapi.repository.UserProfileRepo;
import com.example.opportunityapi.repository.UserRepo;
import com.example.opportunityapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepo userRepo;

    private final UserProfileRepo userProfileRepo;

    private final CompanyProfileRepo companyProfileRepo;

    private final UserMapper userMapper;

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

//    private final SendMailService sendMailService;

    @Override
    public UserRegisterDto register(UserRegisterDto dto) {

//        String verificationCode = RandomStringUtils.randomNumeric(6);
//        sendMailService.sendMail(dto.getEmail(), verificationCode, "confirm your account");

        User user = userMapper.toEntity(dto);

//        user.setEnabled(false);
//        user.setVerificationCode(verificationCode);

        User savedUser = userRepo.save(user);
        if (savedUser.getRole() == Role.COMPANY) {
            companyProfileRepo.save(CompanyProfile.builder()
                    .user(user)
                    .build());
        } else if (savedUser.getRole() == Role.USER) {
            userProfileRepo.save(UserProfile.builder()
                    .user(user)
                    .build());
        }
        return userMapper.toRegisterDto(savedUser);
    }

    @Override
    public UserDto login(UserLoginDto dto) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));

        User user = userRepo.findByEmail(dto.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        var jwt = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);

        UserDto userDto = userMapper.toDto(user);
        userDto.setToken(jwt);
        userDto.setRefreshToken(refreshToken);

        if (user.getRole() == Role.USER) {
            UserProfile userProfile = userProfileRepo.findByUser_Id(user.getId()).get();
            userDto.setProfileId(userProfile.getId());
        }
        if (user.getRole() == Role.COMPANY) {
            CompanyProfile companyProfile = companyProfileRepo.findByUser_Id(user.getId()).get();
            userDto.setProfileId(companyProfile.getId());
        }

        return userDto;
    }

    @Override
    public UserTokenDto refresh(UserRefreshTokenDto dto) {
        String username = jwtService.extractUsername(dto.getRefreshToken());
        User user = userRepo.findByEmail(username).orElseThrow();
        if (jwtService.isTokenValid(dto.getRefreshToken(), user)) {
            String jwt = jwtService.generateToken(user);

            return UserTokenDto.builder()
                    .token(jwt)
                    .refreshToken(dto.getRefreshToken())
                    .build();
        }
        return null;
    }
//
//    @Override
//    public void verificationAccount(UserVerificationDto dto) {
//        User user = userRepo.findByEmail(dto.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email"));
//
//        if (user.getVerificationCode().equals(dto.getCode())) {
//            user.setEnabled(true);
//            userRepo.save(user);
//        } else {
//            throw new IllegalArgumentException("Invalid code");
//        }
//    }
}
