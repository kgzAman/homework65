package com.amanee.shope.controllers;

import com.amanee.shope.dto.FilterDTO;
import com.amanee.shope.dto.ProductDTO;
import com.amanee.shope.entity.Product;
import com.amanee.shope.repository.ProductRepository;
import com.amanee.shope.services.ProductService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Controller
@RequestMapping("/pro")
public class ProductController {
    private final ProductService productService;

    private final ProductRepository productRepository;
    private final ModelMapper mapper= new ModelMapper();

    @GetMapping("products")
    public String getAllProducts(@PageableDefault(value = 2) Pageable pageable, Model model){
        final Page<Product> products= productService.getProducts(pageable);
        model.addAttribute("products",products.getContent());
        model.addAttribute("pages",products.getPageable());
        return "html/product";
    }

    @GetMapping("/filter")
    public String filter(Model model,@ModelAttribute(name = "filter")FilterDTO filter, Pageable pageable) {
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

    @GetMapping("/cart")
    public String cart(Model model, @SessionAttribute(name = Constants.CART_ID, required = false) List<Product> items) {
        if (items != null) {
            model.addAttribute("items", items);
        }
        return "html/cart";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam Integer id, HttpSession sessionfrom) {
        if (sessionfrom != null) {
            try {
                var list = (List<Product>) sessionfrom.getAttribute(Constants.CART_ID);
                list.remove(productRepository.findById(id).get());
            } catch (ClassCastException ignored) { }
        }
        return "redirect:/pro/cart";
    }

    @PostMapping("/cart/add")
    public String addToList(@RequestParam Integer id, HttpSession session) {
        if (session != null) {
            var attr = session.getAttribute(Constants.CART_ID);
            if (attr == null) {
                session.setAttribute(Constants.CART_ID, new ArrayList<String>());
            }
            try {
                var list = (List<Product>) session.getAttribute(Constants.CART_ID);
                list.add(productRepository.findById(id).get());
            } catch (ClassCastException ignored) { }
        }
        return "redirect:/pro/cart";
    }

    @PostMapping("/cart/empty")
    public String emptyCart(HttpSession session) {
        session.removeAttribute(Constants.CART_ID);

        return "redirect:/pro/cart";
    }
}
