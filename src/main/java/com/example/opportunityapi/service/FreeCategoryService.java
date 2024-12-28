package com.example.opportunityapi.service;

import com.example.opportunityapi.model.dto.AddFreeCategoryDto;
import com.example.opportunityapi.model.dto.FreeCategoryDto;

import java.util.List;

public interface FreeCategoryService {

    List<FreeCategoryDto> findAll();

    FreeCategoryDto add(AddFreeCategoryDto dto);

    FreeCategoryDto update(AddFreeCategoryDto dto, int id);

    void delete(int id);

}
