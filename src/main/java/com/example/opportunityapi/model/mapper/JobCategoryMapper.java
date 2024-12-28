package com.example.opportunityapi.model.mapper;


import com.example.opportunityapi.model.dto.FreeCategoryDto;
import com.example.opportunityapi.model.dto.JobCategoryDto;
import com.example.opportunityapi.model.entity.FreeCategory;
import com.example.opportunityapi.model.entity.JobCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobCategoryMapper {

    public List<JobCategoryDto> toDtos(List<JobCategory> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public JobCategoryDto toDto(JobCategory entity) {
        return JobCategoryDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .createdDate(entity.getCreatedDate())
                .build();
    }

}
