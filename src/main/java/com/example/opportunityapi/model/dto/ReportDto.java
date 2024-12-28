package com.example.opportunityapi.model.dto;

import com.example.opportunityapi.model.entity.UserProfile;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder

public class ReportDto {

    private int id;

    private String cause;

    private String details;

    private String imageUrl;

    private UserProfile userProfile;

    private int companyProfileId;

    private LocalDateTime createdDate;

}
