package com.vcr.vcr_project.controller;

import com.vcr.vcr_project.model.product.Product;
import com.vcr.vcr_project.model.payload.product.ProductRequest;
import com.vcr.vcr_project.model.response.Response;
import com.vcr.vcr_project.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/product")
    public ResponseEntity<Response<Product>> addNewProduct(@RequestBody ProductRequest request) {
        Response<Product> response = Response.<Product>builder()
                .payload(service.addNewProduct(request))
                .message("Product has been add successfully")
                .status(HttpStatus.OK).build();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/product")
    public ResponseEntity<Response<List<Product>>> getAllProduct() {
        Response<List<Product>> response = Response.<List<Product>>builder()
                .payload(service.getCategories())
                .message("Get all Product successfully")
                .status(HttpStatus.OK).build();
        return ResponseEntity.ok().body(response);
    }
}
