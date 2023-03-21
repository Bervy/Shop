package com.osipov.effectivemobileproject.dto.history;

import com.osipov.effectivemobileproject.enums.PayStatus;
import com.osipov.effectivemobileproject.model.Product;
import com.osipov.effectivemobileproject.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistoryOutDto {

    private User user;
    private Product product;
    private LocalDateTime dateOfPurchase;
    private PayStatus status;
}