package com.example.opportunityapi.service.impl;

import com.example.opportunityapi.model.dto.AddJobCategoryDto;
import com.example.opportunityapi.model.dto.AddRateDto;
import com.example.opportunityapi.model.dto.JobCategoryDto;
import com.example.opportunityapi.model.dto.RateDto;
import com.example.opportunityapi.model.entity.JobCategory;
import com.example.opportunityapi.model.entity.Rate;
import com.example.opportunityapi.model.mapper.JobCategoryMapper;
import com.example.opportunityapi.model.mapper.RateMapper;
import com.example.opportunityapi.repository.CompanyProfileRepo;
import com.example.opportunityapi.repository.JobCategoryRepo;
import com.example.opportunityapi.repository.RateRepo;
import com.example.opportunityapi.service.JobCategoryService;
import com.example.opportunityapi.service.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobCategoryServiceImpl implements JobCategoryService {


    private final JobCategoryRepo repo;
    private final JobCategoryMapper mapper;


    @Override
    public List<JobCategoryDto> findAll() {
        return mapper.toDtos(repo.findAll());
    }


    @Override
    public JobCategoryDto add(AddJobCategoryDto dto) {
        JobCategory category = JobCategory.builder()
                .name(dto.getName())
                .build();

        JobCategory saved = repo.save(category);

        return mapper.toDto(saved);
    }


    @Override
    public JobCategoryDto update(AddJobCategoryDto dto, int id) {

        JobCategory category = repo.findById(id).get();

        category.setName(dto.getName());

        JobCategory saved = repo.save(category);

        return mapper.toDto(saved);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
