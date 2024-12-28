package com.example.opportunityapi.config;

import com.example.opportunityapi.model.dto.UserDto;
import com.example.opportunityapi.model.dto.UserLoginDto;
import com.example.opportunityapi.model.dto.UserRegisterDto;
import com.example.opportunityapi.model.enums.Role;
import com.example.opportunityapi.repository.UserRepo;
import com.example.opportunityapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@RequiredArgsConstructor
public class AppCommandRunner implements CommandLineRunner {

    private final UserRepo userRepo;
    private final AuthService authService;

    @Transactional
    @Override
    public void run(String... args) {

        if (userRepo.findAll().isEmpty()) {
            UserRegisterDto userRegisterDto = UserRegisterDto.builder()
                    .name("Khalil")
                    .email("admin@gmail.com")
                    .password("12345678a")
                    .phoneNumber("+963942200578")
                    .role(Role.ADMIN)
                    .build();
            authService.register(userRegisterDto);
        }

        UserLoginDto loginDto = UserLoginDto.builder()
                .email("admin@gmail.com").password("12345678a").build();

        UserDto dto = authService.login(loginDto);

        System.out.println("===================Admin===================");
        System.out.println("name: " + dto.getName());
        System.out.println("email: " + dto.getEmail());
        System.out.println("phone: " + dto.getPhoneNumber());
        System.out.println("role: " + dto.getRole());
        System.out.println("token: " + dto.getToken());
        System.out.println("refresh token: " + dto.getRefreshToken());

    }
}
