package com.rahu.springjwt.controllers;

import com.rahu.springjwt.dto.DtoResponse;
import com.rahu.springjwt.dto.SearchQueryDto;
import com.rahu.springjwt.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/all", produces = "application/json")
    public DtoResponse findAllProducts() {
        return productService.findAll();
    }
  @PostMapping("/search")
  public DtoResponse search(@RequestBody SearchQueryDto searchQueryDto) throws IOException {
    return productService.search(searchQueryDto);
  }
}
