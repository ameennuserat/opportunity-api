package com.example.opportunityapi.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cause;

    private String details;

    private String imageUrl;

    private int companyProfileId;

    @ManyToOne
    @JoinColumn(name = "user_profile_id")
    private UserProfile userProfile;


    @CreationTimestamp
    private LocalDateTime createdDate;

}
