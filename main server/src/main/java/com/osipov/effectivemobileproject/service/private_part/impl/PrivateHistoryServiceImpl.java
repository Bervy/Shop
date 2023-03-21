package com.osipov.effectivemobileproject.service.private_part.impl;

import com.osipov.effectivemobileproject.constants.Constants;
import com.osipov.effectivemobileproject.dto.history.HistoryOutDto;
import com.osipov.effectivemobileproject.enums.PayStatus;
import com.osipov.effectivemobileproject.error.ConflictException;
import com.osipov.effectivemobileproject.error.NotFoundException;
import com.osipov.effectivemobileproject.mapper.HistoryMapper;
import com.osipov.effectivemobileproject.model.History;
import com.osipov.effectivemobileproject.model.Product;
import com.osipov.effectivemobileproject.model.User;
import com.osipov.effectivemobileproject.repository.HistoryRepository;
import com.osipov.effectivemobileproject.service.private_part.PrivateHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static com.osipov.effectivemobileproject.error.ExceptionDescriptions.DAY_PASSED;
import static com.osipov.effectivemobileproject.error.ExceptionDescriptions.HISTORY_NOT_FOUND;

@Service
@Transactional
public class PrivateHistoryServiceImpl implements PrivateHistoryService {

    private final HistoryRepository historyRepository;

    @Autowired
    public PrivateHistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public void savePurchase(final User user, final Product product) {
        final History history = History.builder()
                .user(user)
                .product(product)
                .build();
        historyRepository.save(history);
    }

    @Override
    public boolean isCheckBuy(final Long userId, final Long productId) {
        return historyRepository.existsByUserIdAndProductId(userId, productId);
    }

    @Override
    public List<HistoryOutDto> getHistoryByUser(final long userId, final int from, final int size) {
        return HistoryMapper.historyToListOutDto(
                historyRepository.findAllByUserId(userId, PageRequest.of(from, size)));
    }

    @Override
    public HistoryOutDto cancelProduct(final Long historyId, final Long userId) {
        History history = historyRepository.findById(historyId)
                .orElseThrow(() -> new NotFoundException(HISTORY_NOT_FOUND.getTitle()));
        Timestamp timeNow = Timestamp.valueOf(LocalDateTime.now());
        Timestamp cutoffTime = Timestamp.valueOf(history.getDateOfPurchase().plusDays(1));
        if (cutoffTime.before(timeNow)) {
            throw new ConflictException(DAY_PASSED.getTitle());
        }
        Product product = history.getProduct();
        Double refundAmount = refund(product.getPrice());
        history.setStatus(PayStatus.CANCELED);
        history.getUser().setBalance(history.getUser().getBalance() + refundAmount);
        product.setQuantity(history.getProduct().getQuantity() + Constants.RETURN_PRODUCT);
        product.getOrganization().getCreator()
                .setBalance(product.getOrganization().getCreator().getBalance() - refundAmount);
        return HistoryMapper.historyToOutDto(history);
    }

    private Double refund(final Double price) {
        return price - (price * Constants.COMMISSION);
    }
}