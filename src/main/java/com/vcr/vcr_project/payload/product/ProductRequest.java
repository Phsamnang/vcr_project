package com.vcr.vcr_project.payload.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private BigDecimal price;
    private Long categoryId;
    private String image;
    private Boolean isAvailable;
}
