package com.example.opportunityapi.model.mapper;


import com.example.opportunityapi.model.dto.FreeCategoryDto;
import com.example.opportunityapi.model.dto.RateDto;
import com.example.opportunityapi.model.entity.FreeCategory;
import com.example.opportunityapi.model.entity.Rate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FreeCategoryMapper {

    public List<FreeCategoryDto> toDtos(List<FreeCategory> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public FreeCategoryDto toDto(FreeCategory entity) {
        return FreeCategoryDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .createdDate(entity.getCreatedDate())
                .build();
    }

}
