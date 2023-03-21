package com.osipov.effectivemobileproject.dto.product;

import com.osipov.effectivemobileproject.dto.organization.OrganizationShortDto;
import com.osipov.effectivemobileproject.enums.ProductStatus;
import com.osipov.effectivemobileproject.model.Characteristic;
import com.osipov.effectivemobileproject.model.Review;
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
public class ProductOutDto {

    private Long id;
    private String name;
    private String description;
    private OrganizationShortDto organizationShortDto;
    private Double price;
    private Integer quantity;
    private List<Review> review;
    private List<Tag> tags;
    private List<Characteristic> characteristics;
    private ProductStatus productStatus;
}