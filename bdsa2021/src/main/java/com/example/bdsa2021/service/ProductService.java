package com.example.bdsa2021.service;

import com.example.bdsa2021.model.ProductDto;

import java.util.UUID;

public interface ProductService {


    ProductDto getProductById(UUID productId);

}
