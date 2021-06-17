package com.amanee.shope.Controllers;

import com.amanee.shope.DTO.UserDTO;
import com.amanee.shope.Entity.User;
import com.amanee.shope.Repositories.UserRepository;
import com.amanee.shope.Services.UserService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Data
@Controller
@RequestMapping("/user")
public class ClientController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final ModelMapper mapper= new ModelMapper();

    
    @GetMapping("/{id}")
    public String getClient(@PathVariable Integer id, Model model){
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "html/user";
    }

    @PostMapping("/add")
    public String addClient(UserDTO clientDTO){
        User client= new User(clientDTO.getName(),clientDTO.getAddress(),clientDTO.getEmail(),clientDTO.getPassword());
        mapper.map(client, User.class);
        userRepository.save(client);
        return "html/user";
    }


}
