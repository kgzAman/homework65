package com.amanee.shope.repository;

import com.amanee.shope.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;


@Repository
public interface ProductRepository  extends JpaRepository<Product,Integer> {
    Page<Product> findAll(Pageable pageable);
    Page<Product> findAllByNameIsContaining(Pageable pageable,String name);
    Page<Product> findAllByDescriptionIsContaining(Pageable pageable,String description);
    Page<Product>findByPriceBetween(Pageable pageable,BigDecimal min,BigDecimal max);

    Optional<Product> findByName(String name);
}
