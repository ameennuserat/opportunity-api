package com.example.opportunityapi.repository;

import com.example.opportunityapi.model.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepo extends JpaRepository<Report, Integer> {

    List<Report> findAllByCompanyProfileId(int id);

    List<Report> findAllByUserProfile_Id(int id);

}
