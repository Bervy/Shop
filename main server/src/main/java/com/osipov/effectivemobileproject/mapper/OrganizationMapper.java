package com.osipov.effectivemobileproject.mapper;

import com.osipov.effectivemobileproject.dto.organization.OrganizationInDto;
import com.osipov.effectivemobileproject.dto.organization.OrganizationOutDto;
import com.osipov.effectivemobileproject.model.Organization;

public class OrganizationMapper {

    public static Organization dtoInToOrganization(OrganizationInDto organizationInDto) {
        return Organization.builder()
                .name(organizationInDto.getName())
                .description(organizationInDto.getDescription())
                .logo(organizationInDto.getLogo())
                .build();
    }

    public static OrganizationOutDto organizationToDtoOut(Organization organization) {
        return OrganizationOutDto.builder()
                .id(organization.getId())
                .name(organization.getName())
                .description(organization.getDescription())
                .logo(organization.getLogo())
                .build();
    }
}