package com.example.opportunityapi.model.dto;

import com.example.opportunityapi.model.entity.CompanyProfile;
import com.example.opportunityapi.model.entity.JobSubCategory;
import lombok.*;

import java.time.LocalDateTime;


@Setter
@Getter
@Builder
public class JobDto {

    private int id;

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

    private CompanyProfile companyProfile;

    private JobSubCategory jobSubCategory;

    private LocalDateTime createdDate;

}
