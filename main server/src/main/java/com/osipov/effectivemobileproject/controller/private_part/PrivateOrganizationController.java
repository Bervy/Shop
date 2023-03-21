package com.osipov.effectivemobileproject.controller.private_part;

import com.osipov.effectivemobileproject.dto.organization.OrganizationInDto;
import com.osipov.effectivemobileproject.dto.organization.OrganizationOutDto;
import com.osipov.effectivemobileproject.service.private_part.PrivateOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/{userId}/company")
public class PrivateOrganizationController {

    private final PrivateOrganizationService organizationService;

    @Autowired
    public PrivateOrganizationController(PrivateOrganizationService companyService) {
        this.organizationService = companyService;
    }

    @PostMapping()
    public OrganizationOutDto createOrganization(
            @PathVariable final Long userId,
            @RequestBody final OrganizationInDto organizationInDto
    ) {
        return organizationService.createOrganization(userId, organizationInDto);
    }
}