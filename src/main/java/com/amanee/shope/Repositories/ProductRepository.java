package com.amanee.shope.Repositories;

import com.amanee.shope.Entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends CrudRepository<Product,Integer> {
}
