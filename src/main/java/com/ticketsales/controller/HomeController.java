package com.ticketsales.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;


@Controller
public class HomeController {
    @GetMapping({""})
    public ModelAndView home(Model model, HttpSession session) {
        if(session.getAttribute("user") != null) {
            return new ModelAndView("redirect:/user/flights");
        } else {
            return new ModelAndView("home");
        }
    }
}