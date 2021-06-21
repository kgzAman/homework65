package com.amanee.shope.services;

import com.amanee.shope.repository.OrderRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class OrderService {
    private final OrderRepository orderRepository;
}
