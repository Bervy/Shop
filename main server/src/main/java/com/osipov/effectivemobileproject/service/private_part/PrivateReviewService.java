package com.osipov.effectivemobileproject.service.private_part;


import com.osipov.effectivemobileproject.dto.review.ReviewInDto;
import com.osipov.effectivemobileproject.dto.review.ReviewOutDto;

public interface PrivateReviewService {
    ReviewOutDto createReview(Long userId, Long productId, ReviewInDto reviewInDto);
}