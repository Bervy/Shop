package com.osipov.effectivemobileproject.mapper;

import com.osipov.effectivemobileproject.dto.review.ReviewInDto;
import com.osipov.effectivemobileproject.dto.review.ReviewOutDto;
import com.osipov.effectivemobileproject.model.Review;

public class ReviewMapper {

    public static Review dtoInToReview(ReviewInDto reviewInDto) {
        return Review.builder()
                .text(reviewInDto.getText())
                .rating(reviewInDto.getRating())
                .build();
    }

    public static ReviewOutDto reviewToDtoOut(Review review) {
        return ReviewOutDto.builder()
                .product(review.getProduct())
                .text(review.getText())
                .rating(review.getRating())
                .build();
    }
}