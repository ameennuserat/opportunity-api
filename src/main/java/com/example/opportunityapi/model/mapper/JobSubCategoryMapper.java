package com.example.opportunityapi.model.mapper;


import com.example.opportunityapi.model.dto.JobSubCategoryDto;
import com.example.opportunityapi.model.entity.JobSubCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobSubCategoryMapper {

    public List<JobSubCategoryDto> toDtos(List<JobSubCategory> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public JobSubCategoryDto toDto(JobSubCategory entity) {
        return JobSubCategoryDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .jobCategory(entity.getJobCategory())
                .createdDate(entity.getCreatedDate())
                .build();
    }

}
