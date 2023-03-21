package com.osipov.effectivemobileproject.repository;

import com.osipov.effectivemobileproject.enums.OrganizationStatus;
import com.osipov.effectivemobileproject.enums.ProductStatus;
import com.osipov.effectivemobileproject.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByIdAndProductStatusAndOrganization_OrganizationStatus(Long productId, ProductStatus productStatus, OrganizationStatus organizationStatus);

    List<Product> findAllByProductStatusAndOrganization_OrganizationStatus(ProductStatus productStatus, OrganizationStatus organizationStatus, Pageable pageable);

    List<Product> findAllByIdIn(Collection<Long> id);

    @Modifying(clearAutomatically = true)
    @Query(value = "" +
            "UPDATE products " +
            "SET product_status = ?2 " +
            "WHERE id = ?1", nativeQuery = true)
    void productSetStatus(Long userId, String accountStatus);
}