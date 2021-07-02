package com.amanee.shope.controllers;

import com.amanee.shope.entity.Product;
import com.amanee.shope.services.ProductService;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Data
@Controller
@RequestMapping("/main")
public class MainPageController {

    private final ProductService productService;

    @GetMapping
    public String main(Pageable pageable, Model model, Principal principal){
            final Page<Product> products= productService.getProducts(pageable);
            model.addAttribute("products",products.getContent());
            model.addAttribute("pages",products.getPageable());
            model.addAttribute("user",principal);
        return "html/main";
    }

    @PostMapping("/logout")
    public String logoutPage(){
        return "redirect:/main";
    }

}
