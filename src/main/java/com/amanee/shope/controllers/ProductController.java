package com.amanee.shope.controllers;

import com.amanee.shope.dto.FilterDTO;
import com.amanee.shope.dto.ProductDTO;
import com.amanee.shope.entity.Product;
import com.amanee.shope.services.ProductService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.Collectors;

@Data
@Controller
@RequestMapping("/pro")
public class ProductController {
    private final ProductService productService;
    private final ModelMapper mapper= new ModelMapper();

    @GetMapping("/products")
    public String getAllProducts(@PageableDefault(value = 2) Pageable pageable, Model model){
        final Page<Product> products= productService.getProducts(pageable);
        model.addAttribute("products",products.getContent());
        model.addAttribute("pages",products.getPageable());
        return "html/product";
    }

    @GetMapping("/filter")
    public String filter(Model model,@ModelAttribute(name = "filter")FilterDTO filter,@PageableDefault(value = 2) Pageable pageable) {
//
       final Page<Product> products=this.productService.getWithFilter(filter,pageable);
       if(filter.getName()!=null || filter.getDescription()!=null||filter.getMaxPrice()!=null && filter.getMaxPrice()!=null) {
           model.addAttribute("products", products.stream()
                   .map(p -> mapper.map(p, ProductDTO.class))
                   .distinct()
                   .collect(Collectors.toList()));
           model.addAttribute("pages",products.getPageable());
       }
        return "html/filter";
    }

    @PostMapping("/logout")
    public String logoutPage(){
        return "redirect:/login";
    }

}
