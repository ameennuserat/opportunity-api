package com.example.opportunityapi.repository;

import com.example.opportunityapi.model.entity.FreeCategory;
import com.example.opportunityapi.model.entity.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreeCategoryRepo extends JpaRepository<FreeCategory, Integer> {
}
