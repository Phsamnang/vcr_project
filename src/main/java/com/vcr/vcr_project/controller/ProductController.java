package com.vcr.vcr_project.controller;

import com.vcr.vcr_project.payload.product.ProductPriceRequest;
import com.vcr.vcr_project.payload.product.ProductRequest;
import com.vcr.vcr_project.service.product.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class ProductController extends VCRRestController {
    private final IProductService service;

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductRequest request) {
        service.createProduct(request);
        return ok();
    }

    @PatchMapping("product/{id}")
    public ResponseEntity<?> updateImageProduct(@PathVariable("id") Long id, @RequestParam String file) {
        service.updateImageProduct(id, file);
        return ok();
    }

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts() {
        return ok(service.getAllProducts());
    }
    @PutMapping("/product/price")
    public ResponseEntity<?>addProductPrice(@RequestBody ProductPriceRequest request){
        service.productPrice(request);
        return ok();
    }
}
