package com.amanee.shope.Repositories;

import com.amanee.shope.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface ProductRepository  extends JpaRepository<Product,Integer> {
    Page<Product> findAll(Pageable pageable);
    Page<Product> findAllByNameIsContaining(Pageable pageable,String name);
    Page<Product>findByPriceBetween(Pageable pageable,BigDecimal min,BigDecimal max);
}
