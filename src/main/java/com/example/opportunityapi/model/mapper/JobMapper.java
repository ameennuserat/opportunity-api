package com.example.opportunityapi.model.mapper;


import com.example.opportunityapi.model.dto.AddJobDto;
import com.example.opportunityapi.model.dto.JobCategoryDto;
import com.example.opportunityapi.model.dto.JobDto;
import com.example.opportunityapi.model.entity.Job;
import com.example.opportunityapi.model.entity.JobCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobMapper {

    public List<JobDto> toDtos(List<Job> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public JobDto toDto(Job entity) {
        return JobDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .age(entity.getAge())
                .gender(entity.getGender())
                .experience(entity.getExperience())
                .jopType(entity.getJopType())
                .online(entity.getOnline())
                .nationality(entity.getNationality())
                .expiryDate(entity.getExpiryDate())
                .location(entity.getLocation())
                .companyProfile(entity.getCompanyProfile())
                .jobSubCategory(entity.getJobSubCategory())
                .createdDate(entity.getCreatedDate())
                .build();
    }

    public Job toAddEntity(AddJobDto dto) {
        return Job.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .age(dto.getAge())
                .gender(dto.getGender())
                .experience(dto.getExperience())
                .jopType(dto.getJopType())
                .online(dto.getOnline())
                .nationality(dto.getNationality())
                .expiryDate(dto.getExpiryDate())
                .location(dto.getLocation())
                .build();
    }

}
