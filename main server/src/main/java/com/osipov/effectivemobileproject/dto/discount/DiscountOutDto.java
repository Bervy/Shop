package com.osipov.effectivemobileproject.dto.discount;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.osipov.effectivemobileproject.dto.product.ProductOutDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiscountOutDto {
    private Long id;
    private Double discountPercentage;
    private LocalDateTime startDiscount;
    private LocalDateTime finishDiscount;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<ProductOutDto> products;
}