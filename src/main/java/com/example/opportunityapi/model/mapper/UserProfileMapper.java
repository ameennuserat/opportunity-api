package com.example.opportunityapi.model.mapper;


import com.example.opportunityapi.model.dto.UpdateUserProfileDto;
import com.example.opportunityapi.model.dto.UserProfileDto;
import com.example.opportunityapi.model.entity.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserProfileMapper {

    public List<UserProfileDto> toDtos(List<UserProfile> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public UserProfileDto toDto(UserProfile entity) {
        return UserProfileDto.builder()
                .id(entity.getId())
                .userId(entity.getUser().getId())
                .name(entity.getUser().getName())
                .age(entity.getAge())
                .location(entity.getLocation())
                .nationality(entity.getNationality())
                .createdDate(entity.getCreatedDate())
                .educationalLevel(entity.getEducationalLevel())
                .gender(entity.getGender())
                .image_url(entity.getImage_url())
                .pdf_url(entity.getPdf_url())
                .ratingCompanyIds(entity.getRatingCompanyIds())
                .specialty(entity.getSpecialty())
                .build();
    }

    public UserProfile toEntity(UpdateUserProfileDto dto, int id) {
        return UserProfile.builder()
                .id(id)
                .age(dto.getAge())
                .location(dto.getLocation())
                .educationalLevel(dto.getEducationalLevel())
                .gender(dto.getGender())
                .nationality(dto.getNationality())
                .specialty(dto.getSpecialty())
                .build();
    }
}
