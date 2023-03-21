package com.osipov.effectivemobileproject.service.admin_part.impl;

import com.osipov.effectivemobileproject.enums.OrganizationStatus;
import com.osipov.effectivemobileproject.repository.OrganizationRepository;
import com.osipov.effectivemobileproject.service.admin_part.AdminOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdminOrganizationServiceImpl implements AdminOrganizationService {

    private final OrganizationRepository companyRepository;

    @Autowired
    public AdminOrganizationServiceImpl(
            OrganizationRepository companyRepository
    ) {
        this.companyRepository = companyRepository;
    }

    @Override
    public void companySetStatus(final Long companyId, final OrganizationStatus companyStatus) {
        companyRepository.companySetStatus(companyId, companyStatus.toString());
    }
}