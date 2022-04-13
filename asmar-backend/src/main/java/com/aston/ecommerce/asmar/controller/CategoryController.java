package com.aston.ecommerce.asmar.controller;

import com.aston.ecommerce.asmar.dao.CategoryRepository;
import com.aston.ecommerce.asmar.entity.Category;
import com.aston.ecommerce.asmar.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryService categoryService, CategoryRepository categoryRepository) {
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public ResponseEntity<Page<Category>> getCategorylist(
            @RequestParam(value = "offset", defaultValue = "0") Integer page,
            @RequestParam(value = "limit", defaultValue = "10") Integer size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("label"));

        return ResponseEntity.ok(categoryService.getCategoryList(pageable));

    }

}
