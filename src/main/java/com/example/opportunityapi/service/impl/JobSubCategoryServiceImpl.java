package com.example.opportunityapi.service.impl;

import com.example.opportunityapi.model.dto.AddJobSubCategoryDto;
import com.example.opportunityapi.model.dto.JobSubCategoryDto;
import com.example.opportunityapi.model.entity.JobCategory;
import com.example.opportunityapi.model.entity.JobSubCategory;
import com.example.opportunityapi.model.mapper.JobSubCategoryMapper;
import com.example.opportunityapi.repository.JobCategoryRepo;
import com.example.opportunityapi.repository.JobSubCategoryRepo;
import com.example.opportunityapi.service.JobSubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobSubCategoryServiceImpl implements JobSubCategoryService {


    private final JobSubCategoryRepo repo;
    private final JobCategoryRepo jobCategoryRepo;
    private final JobSubCategoryMapper mapper;


    @Override
    public List<JobSubCategoryDto> findAll() {
        return mapper.toDtos(repo.findAll());
    }

    @Override
    public List<JobSubCategoryDto> findAllByCategoryId(int id) {
        return mapper.toDtos(repo.findAllByJobCategory_Id(id));
    }


    @Override
    public JobSubCategoryDto add(AddJobSubCategoryDto dto) {

        JobCategory jobCategory = jobCategoryRepo.findById(dto.getJobCategoryId()).get();

        JobSubCategory subCategory = JobSubCategory.builder()
                .name(dto.getName())
                .jobCategory(jobCategory)
                .build();

        JobSubCategory saved = repo.save(subCategory);

        return mapper.toDto(saved);
    }


    @Override
    public JobSubCategoryDto update(AddJobSubCategoryDto dto, int id) {

        JobCategory jobCategory = jobCategoryRepo.findById(dto.getJobCategoryId()).get();

        JobSubCategory subCategory = repo.findById(id).get();

        subCategory.setName(dto.getName());
        subCategory.setJobCategory(jobCategory);

        JobSubCategory saved = repo.save(subCategory);

        return mapper.toDto(saved);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
