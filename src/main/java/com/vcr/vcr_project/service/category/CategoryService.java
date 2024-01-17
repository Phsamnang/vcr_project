package com.vcr.vcr_project.service.category;

import com.vcr.vcr_project.exception.EntityNotFoundException;
import com.vcr.vcr_project.model.category.Category;
import com.vcr.vcr_project.model.category.CategoryRepository;
import com.vcr.vcr_project.payload.category.CategoryRequest;
import com.vcr.vcr_project.payload.category.CategoryResponse;
import com.vcr.vcr_project.payload.category.MainCategoryResponse;
import com.vcr.vcr_project.payload.product.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final CategoryRepository repository;

    @Override
    public void addNewCategory(CategoryRequest request) {
        repository.save(Category.builder().name(request.getName()).build());
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        List<CategoryResponse> categoryResponses = repository.findAll().stream()
                .map(category -> CategoryResponse.builder()
                        .categoryId(category.getId())
                        .categoryName(category.getName())
                        .build()).collect(Collectors.toList());
        return categoryResponses;
    }

    @Override
    public MainCategoryResponse getCategoryById(Long id) {
        var category = repository.findById(id).orElseThrow(()->new EntityNotFoundException(Category.class,"id",id.toString()));
        List<ProductResponse> productResponses = category.getProducts().stream()
                .filter(product -> product.getIsAvailable()).map(product -> ProductResponse.builder().productName(product.getName())
                        .rielPrice(product.getRielPrice())
                        .UsdPrice(product.getPrice()).productId(product.getId())
                        .image(product.getImage()).build()).collect(Collectors.toList());
        return MainCategoryResponse
                .builder()
                .categoryId(category.getId())
                .categoryName(category.getName())
                .products(productResponses).build();
    }


}
