package com.vcr.vcr_project.controller;

import com.vcr.vcr_project.payload.product.ProductRequest;
import com.vcr.vcr_project.service.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class ProductController extends VCRRestController {
    private final IProductService service;

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest request) {
        service.createProduct(request);
        return ok();
    }


}
