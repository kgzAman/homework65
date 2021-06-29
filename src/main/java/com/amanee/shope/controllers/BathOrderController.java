package com.amanee.shope.controllers;

import com.amanee.shope.entity.BathOrder;
import com.amanee.shope.entity.Product;
import com.amanee.shope.repository.BathOrderRepository;
import com.amanee.shope.repository.ProductRepository;
import com.amanee.shope.services.BathOrderService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Data
@Controller
@RequestMapping("/bath")
public class BathOrderController {

    private final BathOrderService bathOrderService;
    private final BathOrderRepository bathOrderRepository;
    private final ProductRepository productRepository;


    @GetMapping
    public String putBathOrder(Principal principal, Model model){
           BathOrder bathOrder= bathOrderService.getByUserEmail(principal.getName());
           List<Product> products = bathOrder.getProductList();
           model.addAttribute("products",products);
        return "html/bath";
    }

    @GetMapping("/removeAll")
    public String removeAll(Principal principal){
        BathOrder bathOrder= bathOrderService.getByUserEmail(principal.getName());
        bathOrder.getProductList().clear();
        bathOrderRepository.save(bathOrder);
        return "redirect:/bath";
    }
}
