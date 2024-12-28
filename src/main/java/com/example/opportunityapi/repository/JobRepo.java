package com.example.opportunityapi.repository;

import com.example.opportunityapi.model.entity.Job;
import com.example.opportunityapi.model.entity.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<Job, Integer> {

    List<Job> findAllByCompanyProfile_IdOrderByCreatedDateDesc(int id);

}
