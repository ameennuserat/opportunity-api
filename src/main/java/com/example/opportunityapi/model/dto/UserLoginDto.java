package com.example.opportunityapi.model.dto;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
public class UserLoginDto {

    private String email;

    private String password;

}
