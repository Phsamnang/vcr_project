package com.vcr.vcr_project.service;

import com.vcr.vcr_project.model.product.Product;
import com.vcr.vcr_project.model.payload.product.ProductRequest;

import java.util.List;

public interface ProductService {
    Product addNewProduct(ProductRequest request);
    List<Product>getCategories();
}
