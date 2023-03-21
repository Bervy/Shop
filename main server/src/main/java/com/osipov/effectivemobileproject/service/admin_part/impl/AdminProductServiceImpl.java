package com.osipov.effectivemobileproject.service.admin_part.impl;

import com.osipov.effectivemobileproject.dto.product.ProductInDto;
import com.osipov.effectivemobileproject.dto.product.ProductOutDto;
import com.osipov.effectivemobileproject.enums.OrganizationStatus;
import com.osipov.effectivemobileproject.enums.ProductStatus;
import com.osipov.effectivemobileproject.mapper.ProductMapper;
import com.osipov.effectivemobileproject.model.Product;
import com.osipov.effectivemobileproject.repository.ProductRepository;
import com.osipov.effectivemobileproject.service.admin_part.AdminProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AdminProductServiceImpl implements AdminProductService {
    private final ProductRepository productRepository;

    @Autowired
    public AdminProductServiceImpl(
            ProductRepository productRepository
    ) {
        this.productRepository = productRepository;
    }

    @Override
    public void productSetStatus(final Long productId, final ProductStatus companyStatus) {
        productRepository.productSetStatus(productId, companyStatus.toString());
    }

    @Override
    public ProductOutDto updateProduct(final Long productId, final ProductInDto productAdminUpdateDto) {
        Product productUpdate = productRepository.findByIdAndProductStatusAndOrganization_OrganizationStatus(productId,
                ProductStatus.ACTIVE, OrganizationStatus.ACTIVE);
        Optional.ofNullable(productAdminUpdateDto.getName()).ifPresent(productUpdate::setName);
        Optional.ofNullable(productAdminUpdateDto.getDescription()).ifPresent(productUpdate::setDescription);
        Optional.ofNullable(productAdminUpdateDto.getOrganization()).ifPresent(productUpdate::setOrganization);
        Optional.ofNullable(productAdminUpdateDto.getPrice()).ifPresent(productUpdate::setPrice);
        Optional.ofNullable(productAdminUpdateDto.getQuantity()).ifPresent(productUpdate::setQuantity);
        Optional.ofNullable(productAdminUpdateDto.getTags()).ifPresent(productUpdate::setTags);
        Optional.ofNullable(productAdminUpdateDto.getCharacteristics()).ifPresent(productUpdate::setCharacteristics);
        Optional.ofNullable(productAdminUpdateDto.getProductStatus()).ifPresent(productUpdate::setProductStatus);
        return ProductMapper.productToOutDto(productUpdate);
    }
}