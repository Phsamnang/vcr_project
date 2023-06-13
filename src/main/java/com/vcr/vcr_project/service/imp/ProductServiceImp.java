package com.vcr.vcr_project.service.imp;

import com.vcr.vcr_project.model.Product;
import com.vcr.vcr_project.model.request.ProductRequest;
import com.vcr.vcr_project.repository.ProductRepository;
import com.vcr.vcr_project.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    private final ProductRepository repository;

    public ProductServiceImp(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product addNewProduct(ProductRequest request) {
        return repository.addNewProduct(request);
    }

    @Override
    public List<Product> getCategories() {
        return repository.getAllCategories();
    }
}
