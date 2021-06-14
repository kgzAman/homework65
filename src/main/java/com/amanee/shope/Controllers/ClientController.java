package com.amanee.shope.Controllers;

import com.amanee.shope.Entity.Client;
import com.amanee.shope.Services.ClientService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Controller
@RequestMapping("/user")
public class ClientController {
    private final ClientService clientService;

//    @GetMapping("{id}")
//    public String getClient(@PathVariable Integer id, Model model){
//        Client client = clientService.getById(id);
//        model.addAttribute("client", client);
//        return "user";
//    }

}
