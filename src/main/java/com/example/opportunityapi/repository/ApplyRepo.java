package com.example.opportunityapi.repository;

import com.example.opportunityapi.model.entity.Apply;
import com.example.opportunityapi.model.enums.ApplyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyRepo extends JpaRepository<Apply, Integer> {

    List<Apply> findAllByStatus(ApplyStatus status);

    List<Apply> findAllByUserProfile_Id(int id);

    List<Apply> findAllByJob_CompanyProfile_IdOrderByStatus(int id);

}
