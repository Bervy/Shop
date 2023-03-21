package com.osipov.effectivemobileproject.service.private_part.impl;

import com.osipov.effectivemobileproject.dto.review.ReviewInDto;
import com.osipov.effectivemobileproject.dto.review.ReviewOutDto;
import com.osipov.effectivemobileproject.error.ConflictException;
import com.osipov.effectivemobileproject.mapper.ReviewMapper;
import com.osipov.effectivemobileproject.model.Product;
import com.osipov.effectivemobileproject.repository.ReviewRepository;
import com.osipov.effectivemobileproject.service.private_part.PrivateHistoryService;
import com.osipov.effectivemobileproject.service.private_part.PrivateReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.osipov.effectivemobileproject.error.ExceptionDescriptions.USER_DID_NOT_BUY_ITEM;

@Service
@Transactional
public class PrivateReviewServiceImpl implements PrivateReviewService {
    private final ReviewRepository reviewRepository;
    private final PrivateHistoryService historyService;

    @Autowired
    public PrivateReviewServiceImpl(ReviewRepository reviewRepository, PrivateHistoryService historyService) {
        this.reviewRepository = reviewRepository;
        this.historyService = historyService;
    }

    @Override
    public ReviewOutDto createReview(final Long userId, final Long productId, final ReviewInDto reviewInDto) {
        if (!historyService.isCheckBuy(userId, productId)) {
            throw new ConflictException(USER_DID_NOT_BUY_ITEM.getTitle());
        }
        reviewInDto.setProduct(Product.builder().id(productId).build());
        return ReviewMapper.reviewToDtoOut((reviewRepository.save(ReviewMapper.dtoInToReview(reviewInDto))));
    }
}