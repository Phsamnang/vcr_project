package com.vcr.vcr_project.service.category;

import com.vcr.vcr_project.model.category.Category;
import com.vcr.vcr_project.model.category.CategoryRepository;
import com.vcr.vcr_project.model.payload.category.CategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService{
    private final CategoryRepository repository;
    @Override
    public void addNewCategory(CategoryRequest request) {
        repository.save(Category.builder().name(request.getName()).build());
    }

    @Override
    public List<Category> getAllCategories() {
        return null;
    }

    @Override
    public Category updateCategory(Integer id, CategoryRequest request) {
        return null;
    }
}
