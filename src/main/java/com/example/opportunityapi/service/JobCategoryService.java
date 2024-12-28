package com.example.opportunityapi.service;

import com.example.opportunityapi.model.dto.AddJobCategoryDto;
import com.example.opportunityapi.model.dto.AddRateDto;
import com.example.opportunityapi.model.dto.JobCategoryDto;
import com.example.opportunityapi.model.dto.RateDto;

import java.util.List;

public interface JobCategoryService {

    List<JobCategoryDto> findAll();

    JobCategoryDto add(AddJobCategoryDto dto);

    JobCategoryDto update(AddJobCategoryDto dto, int id);

    void delete(int id);

}
