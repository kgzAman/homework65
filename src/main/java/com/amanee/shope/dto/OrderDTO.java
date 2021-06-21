package com.amanee.shope.dto;

import com.amanee.shope.entity.Product;
import com.amanee.shope.entity.User;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class OrderDTO {

    private List<Product> products;

    private User client;

    private LocalTime localTime;

}
