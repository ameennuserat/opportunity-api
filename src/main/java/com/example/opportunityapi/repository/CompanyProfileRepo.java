package com.example.opportunityapi.repository;

import com.example.opportunityapi.model.entity.CompanyProfile;
import com.example.opportunityapi.model.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyProfileRepo extends JpaRepository<CompanyProfile, Integer> {

    Optional<CompanyProfile> findByUser_Id(int id);
}
