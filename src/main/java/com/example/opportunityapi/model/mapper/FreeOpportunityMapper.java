package com.example.opportunityapi.model.mapper;


import com.example.opportunityapi.model.dto.AddFreeOpportunityDto;
import com.example.opportunityapi.model.dto.AddReportDto;
import com.example.opportunityapi.model.dto.FreeCategoryDto;
import com.example.opportunityapi.model.dto.FreeOpportunityDto;
import com.example.opportunityapi.model.entity.FreeCategory;
import com.example.opportunityapi.model.entity.FreeOpportunity;
import com.example.opportunityapi.model.entity.Report;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FreeOpportunityMapper {

    public List<FreeOpportunityDto> toDtos(List<FreeOpportunity> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public FreeOpportunityDto toDto(FreeOpportunity entity) {
        return FreeOpportunityDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .url(entity.getUrl())
                .freeCategory(entity.getFreeCategory())
                .userProfile(entity.getUserProfile())
                .createdDate(entity.getCreatedDate())
                .build();
    }

    public FreeOpportunity toAddEntity(AddFreeOpportunityDto dto) {
        return FreeOpportunity.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .url(dto.getUrl())
                .build();
    }

}
