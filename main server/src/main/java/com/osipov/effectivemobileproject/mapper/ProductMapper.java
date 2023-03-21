package com.osipov.effectivemobileproject.mapper;

import com.osipov.effectivemobileproject.dto.product.ProductInDto;
import com.osipov.effectivemobileproject.dto.product.ProductOutDto;
import com.osipov.effectivemobileproject.model.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductOutDto productToOutDto(Product product) {
        return ProductOutDto.builder()
                .name(product.getName())
                .description(product.getDescription())
                .tags(product.getTags())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .characteristics(product.getCharacteristics())
                .review(product.getReview())
                .build();
    }

    public static Product inDtoToProduct(ProductInDto productInDto) {
        return Product.builder()
                .name(productInDto.getName())
                .description(productInDto.getDescription())
                .tags(productInDto.getTags())
                .price(productInDto.getPrice())
                .quantity(productInDto.getQuantity())
                .characteristics(productInDto.getCharacteristics())
                .build();
    }

    public static List<ProductOutDto> productToListOutDto(List<Product> listProduct) {
        return listProduct.stream().map(ProductMapper::productToOutDto).collect(Collectors.toList());
    }
}
