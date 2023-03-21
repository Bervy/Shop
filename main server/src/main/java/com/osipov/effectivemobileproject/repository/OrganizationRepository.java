package com.osipov.effectivemobileproject.repository;

import com.osipov.effectivemobileproject.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    @Modifying(clearAutomatically = true)
    @Query(value = "" +
            "UPDATE organization " +
            "SET organization_status = ?2 " +
            "WHERE id = ?1", nativeQuery = true)
    void companySetStatus(Long userId, String accountStatus);
}