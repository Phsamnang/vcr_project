package com.vcr.vcr_project.controller;

import com.vcr.vcr_project.model.Category;
import com.vcr.vcr_project.model.request.CategoryRequest;
import com.vcr.vcr_project.model.response.Response;
import com.vcr.vcr_project.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }
    @PostMapping("/category")
    public ResponseEntity<Response<Category>> addNewCategory(@RequestBody CategoryRequest request) {
        Response<Category> response = Response.<Category>builder()
                .payload(service.addNewCategory(request))
                .message("Category has been add successfully")
                .status(HttpStatus.OK).build();
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/category")
    public ResponseEntity<Response<List<Category>>> addNewCategory() {
        Response<List<Category>> response = Response.<List<Category>>builder()
                .payload(service.getAllCategories())
                .message("Get all Categories successfully")
                .status(HttpStatus.OK).build();
        return ResponseEntity.ok().body(response);
    }
    @PostMapping("/category/{id}")
    public ResponseEntity<Response<Category>> updateCategory(@PathVariable("id") Integer id, @RequestBody CategoryRequest request) {
        Response<Category> response = Response.<Category>builder()
                .payload(service.updateCategory(id,request))
                .message("Category has been updated successfully")
                .status(HttpStatus.OK).build();
        return ResponseEntity.ok().body(response);
    }
}
