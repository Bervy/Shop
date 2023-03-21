package com.osipov.effectivemobileproject.service.private_part;

import com.osipov.effectivemobileproject.dto.organization.OrganizationInDto;
import com.osipov.effectivemobileproject.dto.organization.OrganizationOutDto;
import com.osipov.effectivemobileproject.model.Organization;

public interface PrivateOrganizationService {
    OrganizationOutDto createOrganization(Long userId, OrganizationInDto organizationInDto);

    Organization getCompany(Long companyId);
}