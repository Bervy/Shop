package com.osipov.effectivemobileproject.dto.discount;

import com.osipov.effectivemobileproject.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiscountInDto {

    private Double discountPercentage;
    private List<Product> products;
    private LocalDateTime startDiscount;
    private LocalDateTime finishDiscount;
}