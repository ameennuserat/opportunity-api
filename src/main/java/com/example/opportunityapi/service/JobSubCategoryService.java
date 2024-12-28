package com.example.opportunityapi.service;

import com.example.opportunityapi.model.dto.AddJobCategoryDto;
import com.example.opportunityapi.model.dto.AddJobSubCategoryDto;
import com.example.opportunityapi.model.dto.JobCategoryDto;
import com.example.opportunityapi.model.dto.JobSubCategoryDto;

import java.util.List;

public interface JobSubCategoryService {

    List<JobSubCategoryDto> findAll();

    List<JobSubCategoryDto> findAllByCategoryId(int id);

    JobSubCategoryDto add(AddJobSubCategoryDto dto);

    JobSubCategoryDto update(AddJobSubCategoryDto dto, int id);

    void delete(int id);

}
