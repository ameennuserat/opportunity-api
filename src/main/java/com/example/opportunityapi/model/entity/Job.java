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
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String description;

    private int age;

    private String nationality;

    private String gender;

    private String jopType;

    private String experience;

    private String location;

    private String online;

    private LocalDateTime expiryDate;

    @ManyToOne
    @JoinColumn(name = "company_profile_id")
    private CompanyProfile companyProfile;

    @ManyToOne
    @JoinColumn(name = "job_sub_category_id")
    private JobSubCategory jobSubCategory;

    @CreationTimestamp
    private LocalDateTime createdDate;
}
