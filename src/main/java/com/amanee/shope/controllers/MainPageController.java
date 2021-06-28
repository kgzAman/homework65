package com.amanee.shope.controllers;

import com.amanee.shope.services.ProductService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Controller
@RequestMapping("/mainPage")
public class MainPageController {

    private final ProductService productService;

    @PostMapping("/logout")
    public String logoutPage(){
        return "redirect:/login";
    }

}
