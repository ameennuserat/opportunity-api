package com.example.opportunityapi.model.dto;

import lombok.*;

import java.time.LocalDateTime;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobCategoryDto {

    private int id;

    private String name;

    private LocalDateTime createdDate;

}
