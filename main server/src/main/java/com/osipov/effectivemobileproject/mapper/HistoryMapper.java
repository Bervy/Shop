package com.osipov.effectivemobileproject.mapper;

import com.osipov.effectivemobileproject.dto.history.HistoryOutDto;
import com.osipov.effectivemobileproject.model.History;

import java.util.List;
import java.util.stream.Collectors;

public class HistoryMapper {

    public static HistoryOutDto historyToOutDto(History history) {
        return HistoryOutDto.builder()
                .user(history.getUser())
                .product(history.getProduct())
                .dateOfPurchase(history.getDateOfPurchase())
                .status(history.getStatus())
                .build();
    }

    public static List<HistoryOutDto> historyToListOutDto(List<History> listHistory) {
        return listHistory.stream().map(HistoryMapper::historyToOutDto).collect(Collectors.toList());
    }
}