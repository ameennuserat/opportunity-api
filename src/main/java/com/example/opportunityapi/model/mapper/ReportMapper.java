package com.example.opportunityapi.model.mapper;


import com.example.opportunityapi.model.dto.AddJobDto;
import com.example.opportunityapi.model.dto.AddReportDto;
import com.example.opportunityapi.model.dto.JobDto;
import com.example.opportunityapi.model.dto.ReportDto;
import com.example.opportunityapi.model.entity.Job;
import com.example.opportunityapi.model.entity.Report;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportMapper {

    public List<ReportDto> toDtos(List<Report> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public ReportDto toDto(Report entity) {
        return ReportDto.builder()
                .id(entity.getId())
                .cause(entity.getCause())
                .details(entity.getDetails())
                .imageUrl(entity.getImageUrl())
                .userProfile(entity.getUserProfile())
                .companyProfileId(entity.getCompanyProfileId())
                .createdDate(entity.getCreatedDate())
                .build();
    }

    public Report toAddEntity(AddReportDto dto) {
        return Report.builder()
                .cause(dto.getCause())
                .details(dto.getDetails())
                .companyProfileId(dto.getCompanyProfileId())
                .build();
    }

}
