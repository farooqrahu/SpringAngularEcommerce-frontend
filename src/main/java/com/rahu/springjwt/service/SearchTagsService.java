package com.rahu.springjwt.service;


import com.rahu.springjwt.dto.DtoResponse;
import com.rahu.springjwt.dto.SearchTagDto;
import com.rahu.springjwt.repository.SearchTagRepository;
import com.rahu.springjwt.util.CustomConstants;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchTagsService {

    private final SearchTagRepository searchTagRepository;
    private final ModelMapper modelMapper;

    public SearchTagsService(SearchTagRepository searchTagRepository, ModelMapper modelMapper) {
        this.searchTagRepository = searchTagRepository;
        this.modelMapper = modelMapper;
    }

    public DtoResponse findAll() {
        java.lang.reflect.Type targetListType = new TypeToken<List<SearchTagDto>>() {
        }.getType();
        return DtoResponse.builder().message("").code(CustomConstants.INT_SUCCESS).status(CustomConstants.STR_SUCCESS).body(modelMapper.map(searchTagRepository.findAll(), targetListType)).build();
    }
}
