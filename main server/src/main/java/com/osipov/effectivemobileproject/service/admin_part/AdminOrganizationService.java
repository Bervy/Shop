package com.osipov.effectivemobileproject.service.admin_part;

import com.osipov.effectivemobileproject.enums.OrganizationStatus;

public interface AdminOrganizationService {
    void companySetStatus(Long companyId, OrganizationStatus companyStatus);
}