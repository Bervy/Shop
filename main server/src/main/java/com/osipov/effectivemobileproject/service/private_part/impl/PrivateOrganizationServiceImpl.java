package com.osipov.effectivemobileproject.service.private_part.impl;

import com.osipov.effectivemobileproject.dto.organization.OrganizationInDto;
import com.osipov.effectivemobileproject.dto.organization.OrganizationOutDto;
import com.osipov.effectivemobileproject.error.NotFoundException;
import com.osipov.effectivemobileproject.mapper.OrganizationMapper;
import com.osipov.effectivemobileproject.model.Organization;
import com.osipov.effectivemobileproject.model.User;
import com.osipov.effectivemobileproject.repository.OrganizationRepository;
import com.osipov.effectivemobileproject.service.private_part.PrivateOrganizationService;
import com.osipov.effectivemobileproject.service.private_part.PrivateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.osipov.effectivemobileproject.error.ExceptionDescriptions.COMPANY_NOT_FOUND;

@Service
@Transactional
public class PrivateOrganizationServiceImpl implements PrivateOrganizationService {

    private final OrganizationRepository companyRepository;
    private final PrivateUserService userService;

    @Autowired
    public PrivateOrganizationServiceImpl(
            OrganizationRepository companyRepository,
            PrivateUserService userService
    ) {
        this.companyRepository = companyRepository;
        this.userService = userService;
    }

    @Override
    public OrganizationOutDto createOrganization(final Long userId, final OrganizationInDto organizationInDto) {
        User user = userService.getUser(userId);
        organizationInDto.setCreator(user);
        return OrganizationMapper.organizationToDtoOut(
                companyRepository.save(OrganizationMapper.dtoInToOrganization(organizationInDto)));
    }

    @Override
    public Organization getCompany(final Long companyId) {
        return companyRepository.findById(companyId).
                orElseThrow(() -> new NotFoundException(COMPANY_NOT_FOUND.getTitle()));
    }
}