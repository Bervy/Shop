package com.osipov.effectivemobileproject.service.public_part.impl;

import com.osipov.effectivemobileproject.dto.product.ProductOutDto;
import com.osipov.effectivemobileproject.enums.OrganizationStatus;
import com.osipov.effectivemobileproject.enums.ProductStatus;
import com.osipov.effectivemobileproject.mapper.ProductMapper;
import com.osipov.effectivemobileproject.repository.ProductRepository;
import com.osipov.effectivemobileproject.service.public_part.PublicProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PublicProductServiceImpl implements PublicProductService {
    private final ProductRepository productRepository;

    @Autowired
    public PublicProductServiceImpl(
            ProductRepository productRepository
    ) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductOutDto getProduct(final Long productId) {
        return ProductMapper.productToOutDto(productRepository.findByIdAndProductStatusAndOrganization_OrganizationStatus(productId,
                ProductStatus.ACTIVE, OrganizationStatus.ACTIVE));
    }

    @Override
    public List<ProductOutDto> getProducts(final int from, final int size) {
        return ProductMapper.productToListOutDto(productRepository.findAllByProductStatusAndOrganization_OrganizationStatus(
                ProductStatus.ACTIVE, OrganizationStatus.ACTIVE, PageRequest.of(from, size)));
    }
}