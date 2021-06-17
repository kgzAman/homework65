package com.amanee.shope.Controllers;

import com.amanee.shope.DTO.FilterDTO;
import com.amanee.shope.DTO.ProductDTO;
import com.amanee.shope.Entity.Product;
import com.amanee.shope.Services.ProductService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;
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
        return "html/index";
    }
  public String getByDescription(@PageableDefault(value = 2) Pageable pageable, Model model){
        final Page<Product> products= productService.getProducts(pageable);
        model.addAttribute("products",products.getContent());
        model.addAttribute("pages",products.getPageable());
        return "html/index";
    }

    @GetMapping("/filter")
    public String filter(Model model,@ModelAttribute(name = "filter")FilterDTO filter,@PageableDefault(value = 2) Pageable pageable) {
       final Page<Product> products=this.productService.getWithFilter(filter,pageable);
       if(filter.getName()!=null) {
           model.addAttribute("products", products.stream()
                   .map(p -> mapper.map(p, ProductDTO.class))
                   .distinct()
                   .collect(Collectors.toList()));
           model.addAttribute("pages",products.getPageable());
       }

       if(filter.getMaxPrice()!=null && filter.getMaxPrice()!=null){
           model.addAttribute("products",
                   products.stream()
                           .map(p -> mapper.map(p, ProductDTO.class))
                           .collect(Collectors.toList()));
        model.addAttribute("pages",products.getPageable());
       }
        return "html/filter";
    }

}
