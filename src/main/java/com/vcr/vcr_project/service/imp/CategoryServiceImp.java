package com.vcr.vcr_project.service.imp;
import com.vcr.vcr_project.model.Category;
import com.vcr.vcr_project.model.request.CategoryRequest;
import com.vcr.vcr_project.repository.CategoryRepository;
import com.vcr.vcr_project.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {
    private final CategoryRepository repository;

    public CategoryServiceImp(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category addNewCategory(CategoryRequest request) {
        return repository.addNewCategory(request);
    }

    @Override
    public List<Category> getAllCategories() {
        return repository.getAllCategories();
    }

    @Override
    public Category updateCategory(Integer id,CategoryRequest request) {
        return repository.updateCategory(id,request);
    }
}
