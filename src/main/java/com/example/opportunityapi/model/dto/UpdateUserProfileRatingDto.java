package com.example.opportunityapi.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UpdateUserProfileRatingDto {

    private int id;

    private int companyProfileId;

    private String ratingCompanyIds;

    private double totalRating;

    private int review;
}
