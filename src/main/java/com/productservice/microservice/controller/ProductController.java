package com.productservice.microservice.controller;

import com.productservice.microservice.dto.ProductRequest;
import com.productservice.microservice.dto.ProductResponse;
import com.productservice.microservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }
}
