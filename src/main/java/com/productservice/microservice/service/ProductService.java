package com.productservice.microservice.service;

import com.productservice.microservice.dto.ProductRequest;
import com.productservice.microservice.dto.ProductResponse;
import com.productservice.microservice.model.Product;
import com.productservice.microservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product {} is saved ",product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product>products = productRepository.findAll();
        return products.stream()
                .map(this::mapToProductResponse).toList();


    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .description(product.getDescription())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}
