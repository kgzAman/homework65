package com.amanee.shope.Controllers;

import com.amanee.shope.Entity.Client;
import com.amanee.shope.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class MainController {

    private final ClientRepository clientRepository;

    public MainController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/registration_form")
    public String ShowRegistration(Model model){
        Client client = new Client();
        model.addAttribute("client",client);
        return "registration_form";

    }

    @PostMapping("/save")
    public String registration(@ModelAttribute @Valid Client client, BindingResult bindResult,Model model){
        Client client1 = new Client(client.getName(),client.getAddress(),client.getEmail());
        model.addAttribute(client1);
        clientRepository.save(client1);
        return "display_form";
    }
}
