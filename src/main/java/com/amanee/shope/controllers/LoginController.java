package com.amanee.shope.controllers;

import com.amanee.shope.entity.UserRegisterForm;
import com.amanee.shope.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;


@Controller
@RequestMapping("/")
@AllArgsConstructor
public class LoginController {

    private final UserService customerService;

    @GetMapping("/profile")
    public String pageCustomerProfile(Model model, Principal principal)
    {
        var user = customerService.getByEmail(principal.getName());
        model.addAttribute("dto", user);
        return "profile";
    }
//
//    @GetMapping("/register")
//    public String pageRegisterCustomer(Model model) {
//        if (!model.containsAttribute("dto")) {
//            model.addAttribute("dto", new UserRegisterForm());
//        }
//
//        return "html/register";
//    }

    @PostMapping("/register")
    public String registerPage(@Valid UserRegisterForm customerRequestDto,
                               BindingResult validationResult,
                               RedirectAttributes attributes) {
        attributes.addFlashAttribute("dto", customerRequestDto);

        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:register";
        }

        customerService.register(customerRequestDto);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        return "html/login";
    }
//    @RequestMapping(value="/logout", method = RequestMethod.POST)
//    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null){
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return "redirect:/login";
//    }

}
