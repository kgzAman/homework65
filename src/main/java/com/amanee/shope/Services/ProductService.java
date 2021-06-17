package com.amanee.shope.Services;

import com.amanee.shope.DTO.FilterDTO;
import com.amanee.shope.Entity.Product;
import com.amanee.shope.Repositories.ProductRepository;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
@Data
public class ProductService {
    private final ProductRepository productRepository;


    public Page<Product> getProducts(Pageable pageable){
       return productRepository.findAll(pageable);
    }



    public Page<Product> getWithFilter(FilterDTO filterDTO, Pageable pageable) {
        Page<Product> products = null;
        if(filterDTO.getName()!=null){
        products=this.productRepository.findAllByNameIsContaining(pageable,filterDTO.getName());
        }

//        if(filterDTO.getDescription()!=null){
//            products=this.productRepository.findAllByDescriptionIsContaining(pageable,filterDTO.getDescription());
//        }
//
        BigDecimal minRange= BigDecimal.ZERO;
        BigDecimal maxRange=BigDecimal.valueOf(Long.MAX_VALUE);

        if(filterDTO.getMinPrice()!=null && filterDTO.getMaxPrice()!=null){
        minRange=filterDTO.getMinPrice();
        maxRange= filterDTO.getMaxPrice();
        products=this.productRepository.findByPriceBetween(pageable,minRange,filterDTO.getMaxPrice());
        }

        return products;
    }

}
