package com.vcr.vcr_project.service.product;

import com.vcr.vcr_project.model.product.Product;
import com.vcr.vcr_project.payload.product.ProductRequest;

import java.util.List;

public interface IProductService {
   void createProduct(ProductRequest request);
   //loy men ke
   //Orrr
   void updateImageProduct(Long Id,String imageUrl);
}
