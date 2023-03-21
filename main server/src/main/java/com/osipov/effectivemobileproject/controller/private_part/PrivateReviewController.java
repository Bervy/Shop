package com.osipov.effectivemobileproject.controller.private_part;

import com.osipov.effectivemobileproject.dto.review.ReviewInDto;
import com.osipov.effectivemobileproject.dto.review.ReviewOutDto;
import com.osipov.effectivemobileproject.service.private_part.PrivateReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/{userId}/review")
public class PrivateReviewController {

    private final PrivateReviewService reviewService;

    @Autowired
    public PrivateReviewController(PrivateReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping()
    public ReviewOutDto createReview(
            @PathVariable final Long userId,
            @RequestParam final Long productId,
            @RequestBody final ReviewInDto reviewInDto
    ) {
        return reviewService.createReview(userId, productId, reviewInDto);
    }
}