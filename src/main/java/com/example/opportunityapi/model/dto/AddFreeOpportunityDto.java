package com.example.opportunityapi.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder

public class AddFreeOpportunityDto {

    private String title;

    private String description;

    private String url;

    private int userProfileId;

    private int freeCategoryId;

}
