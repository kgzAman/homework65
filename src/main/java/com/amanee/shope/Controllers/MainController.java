package com.amanee.shope.Controllers;

import com.amanee.shope.DTO.UserDTO;
import com.amanee.shope.Entity.User;
import com.amanee.shope.Repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class MainController {

    private final UserRepository userRepository;
    private final ModelMapper mapper= new ModelMapper();

    public MainController(UserRepository clientRepository) {
        this.userRepository = clientRepository;
    }

    @GetMapping("/registration_form")
    public String ShowRegistration(Model model){
        User client = new User();
        model.addAttribute("client",client);
        return "registration_form";

    }

    @PostMapping("/add")
    public String addClient(UserDTO clientDTO){
        User client= new User(clientDTO.getName(),clientDTO.getAddress(),clientDTO.getEmail(),clientDTO.getPassword());
        mapper.map(client, User.class);
        userRepository.save(client);
        return "html/user";
    }
}
