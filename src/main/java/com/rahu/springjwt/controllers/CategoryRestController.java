package com.rahu.springjwt.controllers;

import com.rahu.springjwt.model.Category;
import com.rahu.springjwt.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/category")
public class CategoryRestController {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryRestController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping(value = "/all", produces = "application/json")
    public List<Category> findAllRoles() {
        return categoryRepository.findAll();
    }
}
