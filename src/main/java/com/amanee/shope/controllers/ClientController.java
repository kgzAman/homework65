package com.amanee.shope.controllers;

import com.amanee.shope.entity.User;
import com.amanee.shope.repository.UserRepository;
import com.amanee.shope.services.UserService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Controller
@RequestMapping("/user")
public class ClientController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final ModelMapper mapper= new ModelMapper();


//    @GetMapping("/{id}")
//    public String getClient(@PathVariable Integer id, Model model){
//        User user = userService.getById(id);
//        model.addAttribute("user", user);
//        return "html/user";
//    }



}
