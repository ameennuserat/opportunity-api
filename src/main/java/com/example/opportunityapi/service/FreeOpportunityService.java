package com.example.opportunityapi.service;

import com.example.opportunityapi.model.dto.AddFreeCategoryDto;
import com.example.opportunityapi.model.dto.AddFreeOpportunityDto;
import com.example.opportunityapi.model.dto.FreeCategoryDto;
import com.example.opportunityapi.model.dto.FreeOpportunityDto;

import java.util.List;

public interface FreeOpportunityService {

    List<FreeOpportunityDto> findAll();

    List<FreeOpportunityDto> findAllByUserId(int id);

    FreeOpportunityDto add(AddFreeOpportunityDto dto);

    FreeOpportunityDto update(AddFreeOpportunityDto dto, int id);

    void delete(int id);

}
