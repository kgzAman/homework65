package com.amanee.shope.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FilterDTO {
    private String name;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private String description;
}
