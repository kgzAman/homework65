package com.amanee.shope.controllers;

import com.amanee.shope.services.OrderService;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;
}

