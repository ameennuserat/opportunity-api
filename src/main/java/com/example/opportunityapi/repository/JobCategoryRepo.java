package com.example.opportunityapi.repository;

import com.example.opportunityapi.model.entity.JobCategory;
import com.example.opportunityapi.model.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobCategoryRepo extends JpaRepository<JobCategory, Integer> {
}
