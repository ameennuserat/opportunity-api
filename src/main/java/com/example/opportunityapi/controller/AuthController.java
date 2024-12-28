package com.example.opportunityapi.controller;

import com.example.opportunityapi.model.dto.*;
import com.example.opportunityapi.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    final private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserRegisterDto dto) {
        return new ResponseEntity<>(authService.register(dto),HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserLoginDto dto) {
        return ResponseEntity.ok(authService.login(dto));
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody UserRefreshTokenDto dto) {
        return ResponseEntity.ok(authService.refresh(dto));
    }

//    @PostMapping("/verification")
//    public ResponseEntity<?> verification(@RequestBody UserVerificationDto dto) {
//        authService.verificationAccount(dto);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }

}
