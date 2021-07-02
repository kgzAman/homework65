package com.amanee.shope.services;

import com.amanee.shope.entity.BathOrder;
import com.amanee.shope.entity.Product;
import com.amanee.shope.entity.User;
import com.amanee.shope.repository.BathOrderRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Data
public class BathOrderService {
    private final BathOrderRepository bathOrderRepository;
    private final UserService userService;
    private final ProductService productService;


    public BathOrder getByUser(String email, int id) {
        User user=userService.getByEmail(email);
        BathOrder bathOrder = bathOrderRepository.findByUser(user);
        if(bathOrder==null){
            ArrayList<Product> products = new ArrayList<>();
            products.add(productService.getById(id));
            BathOrder bathOrder1 = new BathOrder();
            bathOrder1.setUser(user);

            bathOrder1.setProductList(products);
            return bathOrder1;
        } else {
             return bathOrder;
        }
    }

    public BathOrder getByUserEmail(String email){
        return bathOrderRepository.findByUserEmail(email);
    }

    public void saveProduct(BathOrder bathOrder) {
        bathOrderRepository.save(bathOrder);
    }
}
