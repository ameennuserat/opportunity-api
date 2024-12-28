package com.example.opportunityapi.model.dto;

import com.example.opportunityapi.model.entity.JobCategory;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder

public class JobSubCategoryDto {
    private int id;

    private String name;

    private JobCategory jobCategory;

    private LocalDateTime createdDate;
}
