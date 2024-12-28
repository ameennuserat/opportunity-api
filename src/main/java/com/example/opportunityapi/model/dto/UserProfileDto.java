package com.example.opportunityapi.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
public class UserProfileDto {

    private int id;

    private int userId;

    private String name;

    private int age;

    private String gender;

    private String educationalLevel;

    private String specialty;

    private String nationality;

    private String location;

    private String image_url;

    private String pdf_url;

    private String ratingCompanyIds;

    private LocalDateTime createdDate;

}
