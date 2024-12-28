package com.example.opportunityapi.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@Builder
public class AddJobDto {

    private String title;

    private String description;

    private int age;

    private String nationality;

    private String gender;

    private String jopType;

    private String experience;

    private String location;

    private String online;

    private LocalDateTime expiryDate;

    private int companyProfileId;

    private int jobSubCategoryId;

}
