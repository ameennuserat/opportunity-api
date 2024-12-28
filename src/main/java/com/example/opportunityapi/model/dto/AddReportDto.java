package com.example.opportunityapi.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@Builder
public class AddReportDto {

    private String cause;

    private String details;

    private MultipartFile imageFile;

    private int userProfileId;

    private int companyProfileId;
    
}
