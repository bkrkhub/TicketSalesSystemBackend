package com.ticketsales.controller;

import com.ticketsales.model.Admin;
import com.ticketsales.services.AdminService;
import com.ticketsales.services.FlightService;
import com.ticketsales.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    FlightService flightService;

    @Autowired
    UserService userService;

    @GetMapping({""})
    public ModelAndView home(HttpSession session, Model model) {
        if(session.getAttribute("admin") == null) {
            return new ModelAndView("redirect:/admin/signin");
        } else {
            model.addAttribute("admin", session.getAttribute("admin"));
            model.addAttribute("list", flightService.getAllFlights());
            model.addAttribute("users", userService.getAllUser());
            return new ModelAndView("admin");
        }
    }

    @GetMapping({"/block"})
    public ModelAndView block(@RequestParam int id, HttpSession session, Model model) {
        if(session.getAttribute("admin") == null) {
            return new ModelAndView("redirect:/admin/signin");
        } else {
            userService.deleteUser(id);
            return new ModelAndView("redirect:/");
        }
    }

    @GetMapping({"/signin"})
    public ModelAndView signin(HttpSession session, Model model) {
        if(session.getAttribute("admin") != null) {
            model.addAttribute("admin", session.getAttribute("admin"));
            return new ModelAndView("redirect:/admin");
        } else {
            return new ModelAndView("adminsignin");
        }
    }

    @GetMapping({"/logout"})
    public ModelAndView logout(HttpSession session) {
        session.removeAttribute("admin");
        return new ModelAndView("redirect:/admin/signin");
    }

    @PostMapping({"/signin"})
    public ModelAndView signinPost(@ModelAttribute Admin admin, Model model, HttpSession session) {
        Admin currentUser = adminService.getAdminByUsername(admin.getUsername());

        if(currentUser == null) {
            return new ModelAndView("redirect:/admin/signin?status=usernotfound");
        }

        if(!(currentUser.getPassword().equals(admin.getPassword()))) {
            return new ModelAndView("redirect:/admin/signin?status=wrongpass");
        }

        session.setAttribute("admin", currentUser);
        model.addAttribute("admin", currentUser);

        return new ModelAndView("redirect:/admin");
    }
}
