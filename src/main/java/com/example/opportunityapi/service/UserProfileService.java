package com.example.opportunityapi.service;

import com.example.opportunityapi.model.dto.*;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

public interface UserProfileService {

    List<UserProfileDto> findAll();

    UserProfileDto findByUserId(int id);

    UserProfileDto findById(int id);

    UserProfileDto update(UpdateUserProfileDto dto) throws IOException;

    @Transactional
    UserProfileDto updateRating(UpdateUserProfileRatingDto dto);

    void delete(int id);

}
