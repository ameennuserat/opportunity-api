package com.example.opportunityapi.service;

import com.example.opportunityapi.model.dto.AddReportDto;
import com.example.opportunityapi.model.dto.ReportDto;

import java.io.IOException;
import java.util.List;

public interface ReportService {

    List<ReportDto> findAll();

    List<ReportDto> findAllByCompanyProfileId(int id);

    List<ReportDto> findAllByUserProfileId(int id);

    ReportDto add(AddReportDto dto) throws IOException;

    void delete(int id);
}
