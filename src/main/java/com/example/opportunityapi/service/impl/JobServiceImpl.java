package com.example.opportunityapi.service.impl;

import com.example.opportunityapi.model.dto.AddJobCategoryDto;
import com.example.opportunityapi.model.dto.AddJobDto;
import com.example.opportunityapi.model.dto.JobCategoryDto;
import com.example.opportunityapi.model.dto.JobDto;
import com.example.opportunityapi.model.entity.*;
import com.example.opportunityapi.model.mapper.JobCategoryMapper;
import com.example.opportunityapi.model.mapper.JobMapper;
import com.example.opportunityapi.repository.*;
import com.example.opportunityapi.service.JobCategoryService;
import com.example.opportunityapi.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {


    private final JobRepo repo;
    private final JobSubCategoryRepo jobSubCategoryRepo;
    private final CompanyProfileRepo companyProfileRepo;
    private final JobMapper mapper;


    @Override
    public List<JobDto> findAll() {
        return mapper.toDtos(repo.findAll());
    }

    @Override
    public List<JobDto> findAllByCompanyProfileId(int id) {
        return mapper.toDtos(repo.findAllByCompanyProfile_IdOrderByCreatedDateDesc(id));
    }


    @Override
    public JobDto add(AddJobDto dto) {

        JobSubCategory jobSubCategory = jobSubCategoryRepo.findById(dto.getJobSubCategoryId()).get();
        CompanyProfile companyProfile = companyProfileRepo.findById(dto.getCompanyProfileId()).get();

        Job job = mapper.toAddEntity(dto);

        job.setJobSubCategory(jobSubCategory);
        job.setCompanyProfile(companyProfile);

        Job saved = repo.save(job);

        //ToDo notifications for followers

        return mapper.toDto(saved);
    }


    @Override
    public JobDto update(AddJobDto dto, int id) {

        JobSubCategory jobSubCategory = jobSubCategoryRepo.findById(dto.getJobSubCategoryId()).get();
        CompanyProfile companyProfile = companyProfileRepo.findById(dto.getCompanyProfileId()).get();

        Job job = repo.findById(id).get();

        Job mappingJob = mapper.toAddEntity(dto);

        mappingJob.setId(job.getId());
        mappingJob.setCreatedDate(job.getCreatedDate());
        mappingJob.setJobSubCategory(jobSubCategory);
        mappingJob.setCompanyProfile(companyProfile);

        Job saved = repo.save(mappingJob);

        return mapper.toDto(saved);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
