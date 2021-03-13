package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl service;

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(service.saveProduct(product), HttpStatus.CREATED);
    }

    @PostMapping("/addProducts")
    public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products) {
        return new ResponseEntity<>(service.saveProducts(products),HttpStatus.CREATED) ;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAllProducts() {

        return new ResponseEntity<>(service.getProducts(),HttpStatus.OK) ;
    }

    @GetMapping("/productById/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable UUID id) {

        return new ResponseEntity<>(service.getProductById(id),HttpStatus.OK) ;
    }

    @GetMapping("/product/{name}")
    public ResponseEntity<Product> findProductByName(@PathVariable String name) {
        return new ResponseEntity<>(service.getProductByName(name),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return new ResponseEntity<>(service.updateProduct(product),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable UUID id) {
        return service.deleteProduct(id);
    }
}
