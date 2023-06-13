package com.vcr.vcr_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer id;
    private Category category;
    private String name;
    private double price;
}
