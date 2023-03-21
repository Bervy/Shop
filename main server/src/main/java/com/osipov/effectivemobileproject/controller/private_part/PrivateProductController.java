package com.osipov.effectivemobileproject.controller.private_part;

import com.osipov.effectivemobileproject.dto.product.ProductInDto;
import com.osipov.effectivemobileproject.dto.product.ProductOutDto;
import com.osipov.effectivemobileproject.service.private_part.PrivateProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/{userId}/product")
public class PrivateProductController {

    private final PrivateProductService productService;

    @Autowired
    public PrivateProductController(PrivateProductService productService) {
        this.productService = productService;
    }

    @PostMapping("{productId}")
    public ProductOutDto buyProduct(
            @PathVariable final Long userId,
            @PathVariable final Long productId
    ) {
        return productService.buyProduct(userId, productId);
    }

    @PostMapping("create")
    public ProductOutDto createProduct(
            @PathVariable final Long userId,
            @RequestParam final Long companyId,
            @RequestBody final ProductInDto productInDto
    ) {
        return productService.createProduct(userId, companyId, productInDto);
    }
}