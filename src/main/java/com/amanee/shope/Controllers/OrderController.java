package com.amanee.shope.Controllers;

import com.amanee.shope.Services.OrderService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("")
public class OrderController {
    private OrderService orderService;
}
