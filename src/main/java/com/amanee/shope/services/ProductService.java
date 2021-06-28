package com.amanee.shope.services;

import com.amanee.shope.dto.FilterDTO;
import com.amanee.shope.dto.ProductDTO;
import com.amanee.shope.entity.Order;
import com.amanee.shope.entity.Product;
import com.amanee.shope.exeption.NotFoundException;
import com.amanee.shope.repository.ProductRepository;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;


@Service
@Data
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Page<Product> getProducts(Pageable pageable){
       return productRepository.findAll(pageable);
    }


    public Page<Product> getWithFilter(FilterDTO filterDTO, Pageable pageable) {
        Page<Product> products = null;
        if(filterDTO.getName()!=null){
        products=this.productRepository.findAllByNameIsContaining(pageable,filterDTO.getName());
        }
        if(filterDTO.getDescription()!=null){
        products=this.productRepository.findAllByDescriptionIsContaining(pageable,filterDTO.getDescription());

        }
        BigDecimal minRange= BigDecimal.ZERO;
        BigDecimal maxRange=BigDecimal.valueOf(Long.MAX_VALUE);

        if(filterDTO.getMinPrice()!=null && filterDTO.getMaxPrice()!=null){
        minRange=filterDTO.getMinPrice();
        maxRange= filterDTO.getMaxPrice();
        products=this.productRepository.findByPriceBetween(pageable,minRange,maxRange);
        }

        return products;
    }
    public Product getById(int orderFor) {
        return productRepository.findById(orderFor).orElseThrow(NotFoundException::new);
    }


}
