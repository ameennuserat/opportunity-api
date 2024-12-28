package com.example.opportunityapi.service.impl;

import com.example.opportunityapi.model.dto.AddFreeCategoryDto;
import com.example.opportunityapi.model.dto.AddJobCategoryDto;
import com.example.opportunityapi.model.dto.FreeCategoryDto;
import com.example.opportunityapi.model.dto.JobCategoryDto;
import com.example.opportunityapi.model.entity.FreeCategory;
import com.example.opportunityapi.model.entity.JobCategory;
import com.example.opportunityapi.model.mapper.FreeCategoryMapper;
import com.example.opportunityapi.model.mapper.JobCategoryMapper;
import com.example.opportunityapi.repository.FreeCategoryRepo;
import com.example.opportunityapi.repository.JobCategoryRepo;
import com.example.opportunityapi.service.FreeCategoryService;
import com.example.opportunityapi.service.JobCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FreeCategoryServiceImpl implements FreeCategoryService {


    private final FreeCategoryRepo repo;
    private final FreeCategoryMapper mapper;


    @Override
    public List<FreeCategoryDto> findAll() {
        return mapper.toDtos(repo.findAll());
    }


    @Override
    public FreeCategoryDto add(AddFreeCategoryDto dto) {
        FreeCategory category = FreeCategory.builder()
                .name(dto.getName())
                .build();

        FreeCategory saved = repo.save(category);

        return mapper.toDto(saved);
    }


    @Override
    public FreeCategoryDto update(AddFreeCategoryDto dto, int id) {

        FreeCategory category = repo.findById(id).get();

        category.setName(dto.getName());

        FreeCategory saved = repo.save(category);

        return mapper.toDto(saved);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
