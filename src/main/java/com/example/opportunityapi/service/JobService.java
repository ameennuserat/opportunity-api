package com.example.opportunityapi.service;

import com.example.opportunityapi.model.dto.AddJobDto;
import com.example.opportunityapi.model.dto.JobDto;

import java.util.List;

public interface JobService {

    List<JobDto> findAll();

    List<JobDto> findAllByCompanyProfileId(int id);

    JobDto add(AddJobDto dto);

    JobDto update(AddJobDto dto, int id);

    void delete(int id);

}
