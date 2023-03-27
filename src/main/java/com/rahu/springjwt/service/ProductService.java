package com.rahu.springjwt.service;


import com.rahu.springjwt.dto.DtoResponse;
import com.rahu.springjwt.dto.ProductDto;
import com.rahu.springjwt.dto.SearchQueryDto;
import com.rahu.springjwt.repository.ProductRepository;
import com.rahu.springjwt.util.CustomConstants;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }


    public DtoResponse findAll() {
        java.lang.reflect.Type targetListType = new TypeToken<List<ProductDto>>() {
        }.getType();
        return DtoResponse.builder().message("").code(CustomConstants.INT_SUCCESS).status(CustomConstants.STR_SUCCESS).body(modelMapper.map(productRepository.findAll(), targetListType)).build();
    }

  public DtoResponse search(SearchQueryDto searchQueryDto) throws IOException {
    java.lang.reflect.Type targetListType = new TypeToken<List<ProductDto>>() {
    }.getType();
    return DtoResponse.builder().message("").code(CustomConstants.INT_SUCCESS).status(CustomConstants.STR_SUCCESS).body(modelMapper.map(productRepository.findByNameContaining(searchQueryDto.getTextQuery()), targetListType)).build();
    }
}
