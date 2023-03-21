package com.osipov.effectivemobileproject.service.private_part;

import com.osipov.effectivemobileproject.dto.history.HistoryOutDto;
import com.osipov.effectivemobileproject.model.Product;
import com.osipov.effectivemobileproject.model.User;

import java.util.List;

public interface PrivateHistoryService {
    void savePurchase(User user, Product product);

    boolean isCheckBuy(Long userId, Long productId);

    List<HistoryOutDto> getHistoryByUser(long userId, int from, int size);

    HistoryOutDto cancelProduct(Long historyId, Long userId);
}