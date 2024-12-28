package com.example.opportunityapi.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@Builder
public class UpdateUserProfileDto {

    private int userId;

    private int age;

    private String gender;

    private String educationalLevel;

    private String specialty;

    private String nationality;

    private String location;

    private MultipartFile imageFile;

    private MultipartFile pdfFile;
}
