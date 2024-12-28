package com.example.opportunityapi.model.dto;

import com.example.opportunityapi.model.entity.FreeCategory;
import com.example.opportunityapi.model.entity.UserProfile;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder

public class FreeOpportunityDto {

    private int id;

    private String title;

    private String description;

    private String url;

    private UserProfile userProfile;

    private FreeCategory freeCategory;

    private LocalDateTime createdDate;

}
