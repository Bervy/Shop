package com.osipov.effectivemobileproject.dto.review;

import com.osipov.effectivemobileproject.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewOutDto {

    private Product product;
    private String text;
    private Integer rating;
}