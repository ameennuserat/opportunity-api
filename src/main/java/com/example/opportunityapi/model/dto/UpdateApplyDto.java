package com.example.opportunityapi.model.dto;

import com.example.opportunityapi.model.enums.ApplyStatus;
import lombok.*;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplyDto {

    private ApplyStatus status;
    
}
