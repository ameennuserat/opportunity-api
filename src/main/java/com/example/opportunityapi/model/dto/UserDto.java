package com.example.opportunityapi.model.dto;

import com.example.opportunityapi.model.enums.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
public class UserDto {
    private int id;
    private int profileId;
    private String name;
    private String email;
    private String phoneNumber;
    private Role role;
    private String token;
    private String refreshToken;
}
