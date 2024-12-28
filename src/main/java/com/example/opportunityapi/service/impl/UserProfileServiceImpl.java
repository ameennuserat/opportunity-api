package com.example.opportunityapi.service.impl;

import com.example.opportunityapi.model.dto.UpdateUserProfileDto;
import com.example.opportunityapi.model.dto.UpdateUserProfileRatingDto;
import com.example.opportunityapi.model.dto.UserProfileDto;
import com.example.opportunityapi.model.entity.CompanyProfile;
import com.example.opportunityapi.model.entity.User;
import com.example.opportunityapi.model.entity.UserProfile;
import com.example.opportunityapi.model.mapper.UserProfileMapper;
import com.example.opportunityapi.repository.CompanyProfileRepo;
import com.example.opportunityapi.repository.UserProfileRepo;
import com.example.opportunityapi.repository.UserRepo;
import com.example.opportunityapi.service.ImageService;
import com.example.opportunityapi.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {


    private final UserProfileRepo repo;
    private final CompanyProfileRepo companyRepo;

    private final UserProfileMapper mapper;

    private final ImageService imageService;

    @Override
    public List<UserProfileDto> findAll() {
        return mapper.toDtos(repo.findAll());
    }

    @Override
    public UserProfileDto findByUserId(int id) {
        return mapper.toDto(repo.findByUser_Id(id).get());
    }

    @Override
    public UserProfileDto findById(int id) {
        return mapper.toDto(repo.findById(id).get());
    }

    @Override
    public UserProfileDto update(UpdateUserProfileDto dto) throws IOException {


        UserProfile userProfile = repo.findByUser_Id(dto.getUserId()).get();

        UserProfile userProfile1 = mapper.toEntity(dto, userProfile.getId());


        if (dto.getImageFile() != null) {
            String imageUrl = imageService.uploadImage(dto.getImageFile());
            userProfile1.setImage_url(imageUrl);
            if (userProfile.getImage_url() != null) {
                imageService.deleteImage(userProfile.getImage_url());
            }
        } else {
            userProfile1.setImage_url(userProfile.getImage_url());
        }

        if (dto.getPdfFile() != null) {
            String pdfUrl = imageService.uploadImage(dto.getPdfFile());
            userProfile1.setPdf_url(pdfUrl);
            if (userProfile.getPdf_url() != null) {
                imageService.deleteImage(userProfile.getPdf_url());
            }
        } else {
            userProfile1.setPdf_url(userProfile.getPdf_url());

        }

        userProfile1.setUser(userProfile.getUser());

        UserProfile saved = repo.save(userProfile1);

        return mapper.toDto(saved);
    }

    @Override
    public UserProfileDto updateRating(UpdateUserProfileRatingDto dto) {
        UserProfile userProfile = repo.findById(dto.getId()).get();

        CompanyProfile companyProfile = companyRepo.findById(dto.getCompanyProfileId()).get();


        companyProfile.setReviewCount(dto.getReview());
        companyProfile.setTotalRate(dto.getTotalRating());

        companyRepo.save(companyProfile);

        userProfile.setRatingCompanyIds(dto.getRatingCompanyIds());


        return mapper.toDto(repo.save(userProfile));
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
