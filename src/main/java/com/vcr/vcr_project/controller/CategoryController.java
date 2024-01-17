package com.vcr.vcr_project.controller;

import com.vcr.vcr_project.model.category.Category;
import com.vcr.vcr_project.model.payload.category.CategoryRequest;
import com.vcr.vcr_project.model.response.Response;
import com.vcr.vcr_project.service.category.ICategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController extends VCRRestController {
    private final ICategoryService service;

    public CategoryController(ICategoryService service) {
        this.service = service;
    }
    @PostMapping("/category")
    public ResponseEntity<?> addNewCategory(@RequestBody CategoryRequest request) {
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
