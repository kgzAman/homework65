package com.amanee.shope.Repositories;

import com.amanee.shope.Entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface OrderRepository extends CrudRepository<Order,Integer> {

}
