package com.example.opportunityapi.model.dto;

import com.example.opportunityapi.model.entity.Job;
import com.example.opportunityapi.model.entity.UserProfile;
import com.example.opportunityapi.model.enums.ApplyStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
public class ApplyDto {

    private int id;

    private UserProfile userProfile;

    private Job job;

    private ApplyStatus status;

    private LocalDateTime createdDate;

}
