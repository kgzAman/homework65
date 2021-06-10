package com.amanee.shope.Services;

import com.amanee.shope.Repositories.ProductRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ProductService {
    private final ProductRepository productRepository;
}
