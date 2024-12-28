package com.example.opportunityapi.service.impl;

import com.example.opportunityapi.model.dto.AddFreeCategoryDto;
import com.example.opportunityapi.model.dto.AddFreeOpportunityDto;
import com.example.opportunityapi.model.dto.FreeCategoryDto;
import com.example.opportunityapi.model.dto.FreeOpportunityDto;
import com.example.opportunityapi.model.entity.FreeCategory;
import com.example.opportunityapi.model.entity.FreeOpportunity;
import com.example.opportunityapi.model.entity.UserProfile;
import com.example.opportunityapi.model.mapper.FreeCategoryMapper;
import com.example.opportunityapi.model.mapper.FreeOpportunityMapper;
import com.example.opportunityapi.repository.FreeCategoryRepo;
import com.example.opportunityapi.repository.FreeOpportunityRepo;
import com.example.opportunityapi.repository.UserProfileRepo;
import com.example.opportunityapi.service.FreeCategoryService;
import com.example.opportunityapi.service.FreeOpportunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FreeOpportunityServiceImpl implements FreeOpportunityService {


    private final FreeOpportunityRepo repo;
    private final FreeCategoryRepo freeCategoryRepo;
    private final UserProfileRepo userProfileRepo;
    private final FreeOpportunityMapper mapper;


    @Override
    public List<FreeOpportunityDto> findAll() {
        return mapper.toDtos(repo.findAll());
    }

    @Override
    public List<FreeOpportunityDto> findAllByUserId(int id) {
        return mapper.toDtos(repo.findAllByUserProfile_IdOrderByCreatedDateDesc(id));
    }


    @Override
    public FreeOpportunityDto add(AddFreeOpportunityDto dto) {

        UserProfile userProfile = userProfileRepo.findById(dto.getUserProfileId()).get();
        FreeCategory freeCategory = freeCategoryRepo.findById(dto.getFreeCategoryId()).get();

        FreeOpportunity opportunity = mapper.toAddEntity(dto);

        opportunity.setUserProfile(userProfile);
        opportunity.setFreeCategory(freeCategory);

        FreeOpportunity saved = repo.save(opportunity);

        return mapper.toDto(saved);
    }

    @Override
    public FreeOpportunityDto update(AddFreeOpportunityDto dto, int id) {

        FreeOpportunity opportunity = repo.findById(id).get();

        UserProfile userProfile = userProfileRepo.findById(dto.getUserProfileId()).get();
        FreeCategory freeCategory = freeCategoryRepo.findById(dto.getFreeCategoryId()).get();

        FreeOpportunity mappingOpportunity = mapper.toAddEntity(dto);
        mappingOpportunity.setId(opportunity.getId());
        mappingOpportunity.setCreatedDate(opportunity.getCreatedDate());
        mappingOpportunity.setUserProfile(userProfile);
        mappingOpportunity.setFreeCategory(freeCategory);

        FreeOpportunity saved = repo.save(mappingOpportunity);

        return mapper.toDto(saved);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }
}
