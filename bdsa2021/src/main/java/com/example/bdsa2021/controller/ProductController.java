package com.example.bdsa2021.controller;

import com.example.bdsa2021.domain.Product;
import com.example.bdsa2021.model.ProductDto;
import com.example.bdsa2021.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    ProductService productService;



    @GetMapping("/product/{productid}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable("productId") UUID productId) {

        return new ResponseEntity<>(productService.getProductById(productId),HttpStatus.OK) ;
    }



}
