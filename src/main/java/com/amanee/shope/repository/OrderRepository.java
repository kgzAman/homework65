package com.amanee.shope.repository;

import com.amanee.shope.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order,Integer> {

}
