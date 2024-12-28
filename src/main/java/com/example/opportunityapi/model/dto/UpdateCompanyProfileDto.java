package com.example.opportunityapi.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@Builder
public class UpdateCompanyProfileDto {

    private int userId;

    private String scope;

    private MultipartFile imageFile;

}
