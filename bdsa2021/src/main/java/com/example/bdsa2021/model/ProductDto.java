package com.example.bdsa2021.model;


import com.example.bdsa2021.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto implements Serializable {

    static final long serialVersionUID = -5815566940065181210L;

    @Null
    private UUID id;

    @NotBlank
    private String name;

    @Positive
    private Integer quantity;

    @Positive
    private BigDecimal price;


}
