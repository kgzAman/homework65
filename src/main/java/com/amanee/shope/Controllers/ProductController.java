package com.amanee.shope.Controllers;

import com.amanee.shope.Services.ProductService;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;


}
