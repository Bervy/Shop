package com.osipov.effectivemobileproject.controller.public_part;

import com.osipov.effectivemobileproject.dto.product.ProductOutDto;
import com.osipov.effectivemobileproject.service.public_part.PublicProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class PublicProductController {

    private final PublicProductService productService;

    @Autowired
    public PublicProductController(PublicProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ProductOutDto getProduct(
            @PathVariable final Long productId
    ) {
        return productService.getProduct(productId);
    }

    @GetMapping()
    public List<ProductOutDto> getProducts(
            @RequestParam(defaultValue = "0") final int from,
            @RequestParam(defaultValue = "10") final int size
    ) {
        return productService.getProducts(from, size);
    }
}