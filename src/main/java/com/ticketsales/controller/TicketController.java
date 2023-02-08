package com.ticketsales.controller;

import com.ticketsales.model.Flight;
import com.ticketsales.model.Ticket;
import com.ticketsales.model.User;
import com.ticketsales.services.FlightService;
import com.ticketsales.services.TicketService;
import com.ticketsales.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/ticket")
public class TicketController {
    @Autowired
    FlightService flightService;

    @Autowired
    TicketService ticketService;

    @Autowired
    UserService userService;

    @GetMapping({"/reservation"})
    public ModelAndView reservation(@RequestParam int flightid, @RequestParam int userid, Model model, HttpSession session, HttpServletResponse response) {
        if (session.getAttribute("user") == null) {
            return new ModelAndView("redirect:/user/signin");
        } else {
            Flight flight = flightService.getFlightById(flightid);
            User user = userService.getUserById(userid);
            Ticket ticket = new Ticket();

            ticket.setFlight(flight);
            ticket.setUser(user);
            Cookie cookie = new Cookie("bilet", flight.getFromLocation() + "-" + flight.getToFrom());
            cookie.setPath("/user/mytickets");
            cookie.setHttpOnly(true);
            cookie.setMaxAge(1 * 24 * 60 * 60);
            response.addCookie(cookie);

            ticketService.addTicket(ticket);

            return new ModelAndView("redirect:/user/mytickets?userid=" + userid);
        }
    }

    @GetMapping({"/reservationcancel"})
    public ModelAndView reservationcancel(@RequestParam int flightid, @RequestParam int userid, Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return new ModelAndView("redirect:/user/signin");
        } else {
            ticketService.deleteTicket(flightid);
            return new ModelAndView("redirect:/user/mytickets?userid=" + userid);
        }
    }
}

