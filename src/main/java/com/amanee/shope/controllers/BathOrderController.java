package com.amanee.shope.controllers;

import com.amanee.shope.entity.BathOrder;
import com.amanee.shope.entity.Product;
import com.amanee.shope.entity.User;
import com.amanee.shope.repository.ProductRepository;
import com.amanee.shope.services.BathOrderService;
import com.amanee.shope.services.ProductService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Data
@Controller
@RequestMapping("/bath")
public class BathOrderController {

    private final BathOrderService bathOrderService;
    private final ProductRepository productRepository;

    @PostMapping
    public void putBathOrder(int id, Principal principal){
         BathOrder bathOrder = bathOrderService.getByUser(principal.getName());
         bathOrder.getProductList().add(productRepository.findById(id).get());
         bathOrderService.saveProduct(bathOrder);

    }
}
