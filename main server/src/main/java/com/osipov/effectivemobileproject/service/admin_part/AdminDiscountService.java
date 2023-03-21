package com.osipov.effectivemobileproject.service.admin_part;


import com.osipov.effectivemobileproject.dto.discount.DiscountOutDto;
import com.osipov.effectivemobileproject.dto.discount.DiscountInDto;

import java.util.Set;

public interface AdminDiscountService {
    DiscountOutDto createDiscount(DiscountInDto discount, Set<Long> productIds);
}
