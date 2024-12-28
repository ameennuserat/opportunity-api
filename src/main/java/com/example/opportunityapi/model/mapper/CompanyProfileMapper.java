package com.example.opportunityapi.model.mapper;


import com.example.opportunityapi.model.dto.CompanyProfileDto;
import com.example.opportunityapi.model.dto.UpdateCompanyProfileDto;
import com.example.opportunityapi.model.entity.CompanyProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyProfileMapper {

    public List<CompanyProfileDto> toDtos(List<CompanyProfile> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public CompanyProfileDto toDto(CompanyProfile entity) {
        return CompanyProfileDto.builder()
                .id(entity.getId())
                .userId(entity.getUser().getId())
                .name(entity.getUser().getName())
                .scope(entity.getScope())
                .imageUrl(entity.getImageUrl())
                .reviewCount(entity.getReviewCount())
                .totalRate(entity.getTotalRate())
                .createdDate(entity.getCreatedDate())
                .build();
    }

    public CompanyProfile toEntity(UpdateCompanyProfileDto dto, int id) {
        return CompanyProfile.builder()
                .id(id)
                .scope(dto.getScope())
                .build();
    }
}
