package com.vcr.vcr_project.service.product;

import com.vcr.vcr_project.model.category.CategoryRepository;
import com.vcr.vcr_project.model.product.Product;
import com.vcr.vcr_project.model.product.ProductRepository;
import com.vcr.vcr_project.payload.product.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;
    @Override
    public void createProduct(ProductRequest request) {
          BigDecimal riel=new BigDecimal(4000);
           var category= categoryRepository.findById(request.getCategoryId()).get();
        repository.save(Product.builder().image(request.getImage())
                .price(request.getPrice().divide(riel))
                .rielPrice(request.getPrice())
                .isAvailable(request.getIsAvailable())
                .name(request.getName())
                .category(category).build());
    }
}
