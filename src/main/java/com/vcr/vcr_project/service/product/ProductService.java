package com.vcr.vcr_project.service.product;

import com.vcr.vcr_project.exception.EntityNotFoundException;
import com.vcr.vcr_project.model.category.CategoryRepository;
import com.vcr.vcr_project.model.product.Product;
import com.vcr.vcr_project.model.product.ProductRepository;
import com.vcr.vcr_project.model.stock.Stock;
import com.vcr.vcr_project.model.stock.StockRepository;
import com.vcr.vcr_project.payload.product.ProductRequest;
import com.vcr.vcr_project.payload.product.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;
    private final StockRepository stockRepository;
    @Override
    public void createProduct(ProductRequest request) {
          BigDecimal riel=new BigDecimal(4000);
           var category= categoryRepository.findById(request.getCategoryId()).get();
      var product=repository.save(Product.builder().image(request.getImage())
                .isAvailable(request.getIsAvailable())
                .name(request.getName())
                .category(category).build());
      stockRepository.save(new Stock(product,0));
    }
    //vakhim

    @Override
    public void updateImageProduct(Long Id, String imageUrl) {
        var product=repository.findById(Id).orElseThrow(()->new EntityNotFoundException(Product.class,"id",Id.toString()));
        product.setImage(imageUrl);
        repository.save(product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        var products=repository.findAll();
        List<ProductResponse> responses=products
                .stream().map(product -> ProductResponse.builder().productId(product.getId())
                        .productName(product.getName())
                        .stockQty(stockRepository.findByProduct(product).getNumber())
                        .categoryName(product.getCategory().getName()).build()).collect(Collectors.toList());
        return responses;
    }
}

