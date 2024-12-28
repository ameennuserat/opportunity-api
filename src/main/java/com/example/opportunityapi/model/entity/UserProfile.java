package com.example.opportunityapi.model.entity;

import com.example.opportunityapi.model.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserProfile  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int age;

    private String gender;

    private String educationalLevel;

    private String specialty;

    private String nationality;

    private String location;

    private String image_url;

    private String pdf_url;

    private String ratingCompanyIds;

    @CreationTimestamp
    private LocalDateTime createdDate;

}
