package com.osipov.effectivemobileproject.controller.admin_part;

import com.osipov.effectivemobileproject.enums.OrganizationStatus;
import com.osipov.effectivemobileproject.service.admin_part.AdminOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/company/{companyId}")
public class AdminOrganizationController {

    private final AdminOrganizationService adminOrganizationService;

    @Autowired
    public AdminOrganizationController(AdminOrganizationService adminOrganizationService) {
        this.adminOrganizationService = adminOrganizationService;
    }

    @PatchMapping()
    public void companySetStatus(
            @PathVariable final Long companyId,
            @RequestParam final OrganizationStatus companyStatus
    ) {
        adminOrganizationService.companySetStatus(companyId, companyStatus);
    }
}