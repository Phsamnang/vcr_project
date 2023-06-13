package com.vcr.vcr_project.service;

import com.vcr.vcr_project.model.Category;
import com.vcr.vcr_project.model.request.CategoryRequest;

import java.util.List;

public interface CategoryService {
    Category addNewCategory(CategoryRequest request);
    List<Category>getAllCategories();
    Category updateCategory(Integer id,CategoryRequest request);
}
