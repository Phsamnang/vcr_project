package com.vcr.vcr_project.service.category;

import com.vcr.vcr_project.model.category.Category;
import com.vcr.vcr_project.model.payload.category.CategoryRequest;

import java.util.List;

public interface ICategoryService {
    void addNewCategory(CategoryRequest request);
    List<Category>getAllCategories();
    Category updateCategory(Integer id,CategoryRequest request);
}
