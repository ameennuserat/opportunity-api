package com.example.opportunityapi.service.impl;

import com.example.opportunityapi.model.dto.AddReportDto;
import com.example.opportunityapi.model.dto.ReportDto;
import com.example.opportunityapi.model.entity.Report;
import com.example.opportunityapi.model.entity.UserProfile;
import com.example.opportunityapi.model.mapper.ReportMapper;
import com.example.opportunityapi.repository.ReportRepo;
import com.example.opportunityapi.repository.UserProfileRepo;
import com.example.opportunityapi.service.ImageService;
import com.example.opportunityapi.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {


    private final ReportRepo repo;
    private final UserProfileRepo userProfileRepo;
    private final ReportMapper mapper;

    private final ImageService imageService;


    @Override
    public List<ReportDto> findAll() {
        return mapper.toDtos(repo.findAll());
    }

    @Override
    public List<ReportDto> findAllByCompanyProfileId(int id) {
        return mapper.toDtos(repo.findAllByCompanyProfileId(id));
    }

    @Override
    public List<ReportDto> findAllByUserProfileId(int id) {
        return mapper.toDtos(repo.findAllByUserProfile_Id(id));
    }


    @Override
    public ReportDto add(AddReportDto dto) throws IOException {

        UserProfile userProfile = userProfileRepo.findById(dto.getUserProfileId()).get();

        Report report = mapper.toAddEntity(dto);


        if (dto.getImageFile() != null) {
            String imageUrl = imageService.uploadImage(dto.getImageFile());
            report.setImageUrl(imageUrl);
        }

        report.setUserProfile(userProfile);

        Report saved = repo.save(report);

        return mapper.toDto(saved);
    }


    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
