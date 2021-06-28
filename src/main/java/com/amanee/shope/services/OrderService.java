package com.amanee.shope.services;

import com.amanee.shope.entity.Order;
import com.amanee.shope.exeption.NotFoundException;
import com.amanee.shope.repository.OrderRepository;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Data
public class OrderService {
    private final OrderRepository orderRepository;

    public Page<Order>getAllOrders(Pageable pageable){
        return orderRepository.findAll(pageable);
    }

    public Order getById(int orderFor) {
      return orderRepository.findById(orderFor).orElseThrow(NotFoundException::new);
    }
}
