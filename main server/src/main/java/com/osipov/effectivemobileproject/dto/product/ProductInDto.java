package com.osipov.effectivemobileproject.dto.product;

import com.osipov.effectivemobileproject.enums.ProductStatus;
import com.osipov.effectivemobileproject.model.Characteristic;
import com.osipov.effectivemobileproject.model.Organization;
import com.osipov.effectivemobileproject.model.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductInDto {
    private String name;
    private String description;
    private Organization organization;
    private Double price;
    private Integer quantity;
    private List<Tag> tags;
    private List<Characteristic> characteristics;
    private ProductStatus productStatus;
}