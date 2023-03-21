package com.osipov.effectivemobileproject.controller.admin_part;

import com.osipov.effectivemobileproject.dto.product.ProductInDto;
import com.osipov.effectivemobileproject.dto.product.ProductOutDto;
import com.osipov.effectivemobileproject.enums.ProductStatus;
import com.osipov.effectivemobileproject.service.admin_part.AdminProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin/product/{productId}")
public class AdminProductController {

    private final AdminProductService adminProductService;

    @Autowired
    public AdminProductController(AdminProductService adminProductService) {
        this.adminProductService = adminProductService;
    }

    @PatchMapping()
    public void productSetStatus(
            @PathVariable final Long productId,
            @RequestParam final ProductStatus companyStatus
    ) {
        adminProductService.productSetStatus(productId, companyStatus);
    }

    @PutMapping()
    public ProductOutDto adminUpdateProduct(
            @PathVariable final Long productId,
            @RequestBody final ProductInDto productInDto
    ) {
        return adminProductService.updateProduct(productId, productInDto);
    }
}