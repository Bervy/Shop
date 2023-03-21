package com.osipov.effectivemobileproject.dto.organization;

import com.osipov.effectivemobileproject.enums.OrganizationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationShortDto {
    private String name;
    private String description;
    private OrganizationStatus companyStatus;
}