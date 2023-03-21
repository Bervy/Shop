package com.osipov.effectivemobileproject.service.admin_part;

import com.osipov.effectivemobileproject.dto.product.ProductInDto;
import com.osipov.effectivemobileproject.dto.product.ProductOutDto;
import com.osipov.effectivemobileproject.enums.ProductStatus;

public interface AdminProductService {
    void productSetStatus(Long productId, ProductStatus companyStatus);
    ProductOutDto updateProduct(Long productId, ProductInDto productAdminUpdateDto);
}