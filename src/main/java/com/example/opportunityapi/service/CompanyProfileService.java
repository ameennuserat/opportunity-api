package com.example.opportunityapi.service;

import com.example.opportunityapi.model.dto.CompanyProfileDto;
import com.example.opportunityapi.model.dto.UpdateCompanyProfileDto;

import java.io.IOException;
import java.util.List;

public interface CompanyProfileService {

    List<CompanyProfileDto> findAll();

    CompanyProfileDto findById(int id);

    CompanyProfileDto update(UpdateCompanyProfileDto dto) throws IOException;

    void delete(int id);

}
