package com.example.opportunityapi.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
public class CompanyProfileDto {

    private int id;

    private int userId;

    private String name;

    private String scope;

    private String imageUrl;

    private int reviewCount;

    private double totalRate;

    private LocalDateTime createdDate;

}
