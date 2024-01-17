package com.vcr.vcr_project.service.category;

import com.vcr.vcr_project.payload.category.CategoryRequest;
import com.vcr.vcr_project.payload.category.CategoryResponse;
import com.vcr.vcr_project.payload.category.MainCategoryResponse;

import java.util.List;

public interface ICategoryService {
    void addNewCategory(CategoryRequest request);
    List<CategoryResponse>getAllCategories();
    MainCategoryResponse getCategoryById(Long id);
}
