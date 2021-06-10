package com.amanee.shope.Services;

import com.amanee.shope.Repositories.OrderRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class OrderService {
    private final OrderRepository orderRepository;
}
