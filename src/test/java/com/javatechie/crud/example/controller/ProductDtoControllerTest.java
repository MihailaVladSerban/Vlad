package com.javatechie.crud.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatechie.crud.example.model.ProductDto;
import com.javatechie.crud.example.service.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
class ProductDtoControllerTest {

    @MockBean
    ProductServiceImpl productServiceImpl;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    ProductDto validProductDto;

    @Before
    public void setUp() {
        validProductDto = ProductDto.builder().id(UUID.randomUUID())
                .name("Ovidiu")
                .quantity(10)
                .price(new BigDecimal("10.15"))
                .build();
    }

    @Test
    public void getBeer() throws Exception {
        given(productServiceImpl.getProductById(any(UUID.class))).willReturn(validProductDto);

        mockMvc.perform(get("/api/v1/product/" + validProductDto.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(validProductDto.getId().toString())))
                .andExpect(jsonPath("$.name", is("Ovidiu")));
    }

    @Test
    public void handlePost() throws Exception {
        //given
        ProductDto productDto = validProductDto;
        productDto.setId(null);
        ProductDto savedDto = ProductDto.builder().id(UUID.randomUUID()).name("New Product").build();
        String beerDtoJson = objectMapper.writeValueAsString(productDto);

        given(productServiceImpl.saveProduct(any())).willReturn(savedDto);

        mockMvc.perform(post("/api/v1/product/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoJson))
                .andExpect(status().isCreated());

    }

    @Test
    public void handleUpdate() throws Exception {
        //given
        ProductDto productDto = validProductDto;
        productDto.setId(null);
        String productDtoJson = objectMapper.writeValueAsString(productDto);

        //when
        mockMvc.perform(put("/api/v1/product/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(productDtoJson))
                .andExpect(status().isNoContent());

        then(productServiceImpl).should().updateProduct(any(),any());

    }
}