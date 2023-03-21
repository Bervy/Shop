package com.osipov.effectivemobileproject.service.private_part;

import com.osipov.effectivemobileproject.dto.product.ProductInDto;
import com.osipov.effectivemobileproject.dto.product.ProductOutDto;
import com.osipov.effectivemobileproject.model.Product;

import java.util.Collection;
import java.util.List;

public interface PrivateProductService {
    ProductOutDto buyProduct(Long userId, Long productId);

    ProductOutDto createProduct(Long userId, Long companyId, ProductInDto productInDtop);

    List<ProductOutDto> getProducts(int from, int size);

    List<Product> getProductsIn(Collection<Long> productIds);

    ProductOutDto getProduct(Long productId);
}
