package com.example.opportunityapi.model.mapper;


import com.example.opportunityapi.model.dto.ApplyDto;
import com.example.opportunityapi.model.entity.Apply;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplyMapper {

    public List<ApplyDto> toDtos(List<Apply> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public ApplyDto toDto(Apply entity) {
        return ApplyDto.builder()
                .id(entity.getId())
                .job(entity.getJob())
                .userProfile(entity.getUserProfile())
                .status(entity.getStatus())
                .createdDate(entity.getCreatedDate())
                .build();
    }

}
