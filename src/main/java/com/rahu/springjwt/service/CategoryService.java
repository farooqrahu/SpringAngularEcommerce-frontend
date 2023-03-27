package com.rahu.springjwt.service;

import com.rahu.springjwt.dto.CategoryDto;
import com.rahu.springjwt.dto.DtoResponse;
import com.rahu.springjwt.repository.CategoryRepository;
import com.rahu.springjwt.util.CustomConstants;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }


    public DtoResponse findAll() {
        java.lang.reflect.Type targetListType = new TypeToken<List<CategoryDto>>() {
        }.getType();
        return DtoResponse.builder().message("").code(CustomConstants.INT_SUCCESS).status(CustomConstants.STR_SUCCESS).body(modelMapper.map(categoryRepository.findAll(), targetListType)).build();
    }

}
