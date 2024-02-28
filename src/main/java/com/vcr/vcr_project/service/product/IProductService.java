package com.vcr.vcr_project.service.product;

import com.vcr.vcr_project.model.product.Product;
import com.vcr.vcr_project.payload.product.ProductPriceRequest;
import com.vcr.vcr_project.payload.product.ProductRequest;
import com.vcr.vcr_project.payload.product.ProductResponse;

import java.util.List;

public interface IProductService {
   void createProduct(ProductRequest request);

   void updateImageProduct(Long Id,String imageUrl);
   List<ProductResponse>getAllProducts();

   void productPrice(ProductPriceRequest request);
}
