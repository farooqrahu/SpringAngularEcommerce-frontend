package com.rahu.springjwt.controllers;

import com.rahu.springjwt.dto.DtoResponse;
import com.rahu.springjwt.service.SearchTagsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/search_tags")
public class SearchTagController {

    private final SearchTagsService searchTagsService;

    public SearchTagController(SearchTagsService searchTagsService) {
        this.searchTagsService = searchTagsService;
    }

    @GetMapping(value = "/all")
    public DtoResponse all() {
        return searchTagsService.findAll();
    }
}
