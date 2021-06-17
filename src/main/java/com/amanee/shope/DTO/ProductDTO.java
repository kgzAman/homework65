package com.amanee.shope.DTO;

import com.amanee.shope.Entity.Type;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {


    private String name;

    private String description;


    private BigDecimal price;


    private int amount;

    private String img;

    private Type type;
}
