package com.osipov.effectivemobileproject.service.public_part;

import com.osipov.effectivemobileproject.dto.product.ProductOutDto;

import java.util.List;

public interface PublicProductService {
    List<ProductOutDto> getProducts(int from, int size);

    ProductOutDto getProduct(Long productId);
}
