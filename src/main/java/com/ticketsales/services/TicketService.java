package com.ticketsales.services;

import com.ticketsales.model.Ticket;

import java.util.List;

public interface TicketService {
    public List<Ticket> getAllTicket();
    public Ticket getTicketById(int id);
    public void addTicket(Ticket ticket);
    public void deleteTicket(int id);
    public List<Ticket> getByUserIdTickets(int userid);
}