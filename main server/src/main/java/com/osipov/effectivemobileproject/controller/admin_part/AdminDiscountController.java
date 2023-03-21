package com.osipov.effectivemobileproject.controller.admin_part;

import com.osipov.effectivemobileproject.dto.discount.DiscountOutDto;
import com.osipov.effectivemobileproject.dto.discount.DiscountInDto;
import com.osipov.effectivemobileproject.service.admin_part.AdminDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("admin/product/discount")
public class AdminDiscountController {

    private final AdminDiscountService adminDiscountService;

    @Autowired
    public AdminDiscountController(AdminDiscountService adminDiscountService) {
        this.adminDiscountService = adminDiscountService;
    }

    @PostMapping
    public DiscountOutDto createDiscount(
            @RequestBody DiscountInDto discountInDto,
            @RequestParam Set<Long> productIds
    ) {
        return adminDiscountService.createDiscount(discountInDto, productIds);
    }
}