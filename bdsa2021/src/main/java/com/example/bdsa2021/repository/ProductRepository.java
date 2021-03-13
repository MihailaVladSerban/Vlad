package com.example.bdsa2021.repository;

import com.example.bdsa2021.domain.Product;
import com.example.bdsa2021.model.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface ProductRepository extends JpaRepository<Product, UUID> {


    Product findByName(String name);

    Product saveById(UUID productId);
}
