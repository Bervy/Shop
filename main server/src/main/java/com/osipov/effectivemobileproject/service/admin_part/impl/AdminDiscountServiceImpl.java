package com.osipov.effectivemobileproject.service.admin_part.impl;

import com.osipov.effectivemobileproject.dto.discount.DiscountInDto;
import com.osipov.effectivemobileproject.dto.discount.DiscountOutDto;
import com.osipov.effectivemobileproject.mapper.DiscountMapper;
import com.osipov.effectivemobileproject.repository.DiscountRepository;
import com.osipov.effectivemobileproject.service.admin_part.AdminDiscountService;
import com.osipov.effectivemobileproject.service.private_part.PrivateProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class AdminDiscountServiceImpl implements AdminDiscountService {

    private final DiscountRepository discountRepository;
    private final PrivateProductService productService;

    @Autowired
    public AdminDiscountServiceImpl(DiscountRepository discountRepository, PrivateProductService productService) {
        this.discountRepository = discountRepository;
        this.productService = productService;
    }

    @Override
    public DiscountOutDto createDiscount(DiscountInDto discountInDto, Set<Long> productIds) {
        discountInDto.setProducts(productService.getProductsIn(productIds));
        return DiscountMapper.discountToDtoOut(
                discountRepository.save(DiscountMapper.dtoInToDiscount(discountInDto)));
    }
}