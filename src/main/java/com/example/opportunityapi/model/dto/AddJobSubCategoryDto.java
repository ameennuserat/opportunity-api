package com.example.opportunityapi.model.dto;

import com.example.opportunityapi.model.entity.JobCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder

public class AddJobSubCategoryDto {

    private String name;

    private int jobCategoryId;

}
