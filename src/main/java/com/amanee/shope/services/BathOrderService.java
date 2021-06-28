package com.amanee.shope.services;

import com.amanee.shope.entity.BathOrder;
import com.amanee.shope.entity.Product;
import com.amanee.shope.entity.User;
import com.amanee.shope.exeption.NotFoundException;
import com.amanee.shope.repository.BathOrderRepository;
import com.amanee.shope.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class BathOrderService {
    private final BathOrderRepository bathOrderRepository;
    private final UserService userService;


    public BathOrder getByUser(String email) {
        User user = userService.getByEmail(email);
      return  bathOrderRepository.findByUser(user).orElseThrow(NotFoundException::new);
    }

    public void saveProduct(BathOrder bathOrder) {
        bathOrderRepository.save(bathOrder);
    }
}
