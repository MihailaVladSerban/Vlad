package com.example.bdsa2021.service;


import com.example.bdsa2021.domain.Product;
import com.example.bdsa2021.model.ProductDto;
import com.example.bdsa2021.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private final ProductRepository productRepository;


    @Override
    public ProductDto getProductById(UUID productId) {
        Optional<Product> product = productRepository.findById(productId);
        return Product.builder().name("vlad")

    }
}
