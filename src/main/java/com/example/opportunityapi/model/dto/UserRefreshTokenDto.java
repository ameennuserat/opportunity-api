package com.example.opportunityapi.model.dto;

import lombok.*;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRefreshTokenDto {
    private String refreshToken;
}
