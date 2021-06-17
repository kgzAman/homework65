package com.amanee.shope.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FilterDTO {
    private String name;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;

}
