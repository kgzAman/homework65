package com.amanee.shope.DTO;

import com.amanee.shope.Entity.Product;
import com.amanee.shope.Entity.User;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class OrderDTO {

    private List<Product> products;

    private User client;

    private LocalTime localTime;

}
