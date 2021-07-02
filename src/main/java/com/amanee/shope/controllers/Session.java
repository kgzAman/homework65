package com.amanee.shope.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
//
//@Controller
//public class Session {
//
//    @GetMapping("/")
//    public String index(Model model, HttpSession session) {
//        var map = new HashMap<String, Object>();
//        map.put("Идентификатор сессии", session.getId());
//
//        session.getAttributeNames()
//                .asIterator()
//                .forEachRemaining(key -> map.put(key, session.getAttribute(key).toString()));
//
//        model.addAttribute("sessionAttributes", map);
//        return "html/filter";
//    }
//
//    @GetMapping("/invalidate")
//    public String invalidate(HttpSession session) {
//        if (session != null) {
//            session.invalidate();
//        }
//
//        return "redirect:/";
//    }
//
//
//}
