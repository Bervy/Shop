package com.osipov.effectivemobileproject.mapper;

import com.osipov.effectivemobileproject.dto.discount.DiscountInDto;
import com.osipov.effectivemobileproject.dto.discount.DiscountOutDto;
import com.osipov.effectivemobileproject.model.Discount;

public class DiscountMapper {

    public static Discount dtoInToDiscount(DiscountInDto discountInDto) {
        return Discount.builder()
                .discountPercentage(discountInDto.getDiscountPercentage())
                .startDiscount(discountInDto.getStartDiscount())
                .finishDiscount(discountInDto.getFinishDiscount())
                .build();
    }

    public static DiscountOutDto discountToDtoOut(Discount discount) {
        return DiscountOutDto.builder()
                .id(discount.getId())
                .discountPercentage(discount.getDiscountPercentage())
                .startDiscount(discount.getStartDiscount())
                .finishDiscount(discount.getFinishDiscount())
                .build();
    }
}