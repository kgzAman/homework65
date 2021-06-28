package com.amanee.shope.controllers;

import com.amanee.shope.dto.ReviewsDTO;
import com.amanee.shope.entity.Order;
import com.amanee.shope.entity.Review;
import com.amanee.shope.entity.User;
import com.amanee.shope.repository.OrderRepository;
import com.amanee.shope.repository.UserRepository;
import com.amanee.shope.services.OrderService;
import com.amanee.shope.services.UserService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@Data
@Controller
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;
    private UserService userService;
    private UserRepository userRepository;
    private OrderRepository orderRepository;
    ModelMapper modelMapper = new ModelMapper();

    public OrderController(OrderService orderService, UserService userService, UserRepository userRepository, OrderRepository orderRepository) {
        this.orderService = orderService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public String getAllOrders(@PageableDefault(value = 2)Pageable pageable,Model model){
      Page<Order> allOrders= orderService.getAllOrders(pageable);
        model.addAttribute("orders",allOrders.getContent());
        model.addAttribute("pages",allOrders.getPageable());
      return "html/orders";
    }

    @PostMapping("/addReview")
    public String addReview(@ModelAttribute(name = "comment")ReviewsDTO reviewsDTO, Principal principal){
        User user = userService.getByEmail(principal.getName());
        Order order = orderService.getById(reviewsDTO.getOrderFor());
        Review review = new Review(user,order,reviewsDTO.getReviewContent(),reviewsDTO.getLocalDateTime(),reviewsDTO.getRating());
        order.getReview().add(review);
        orderRepository.save(order);
        return "redirect:/orders";
    }

}

