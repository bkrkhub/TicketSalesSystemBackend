package com.ticketsales.repository;

import com.ticketsales.model.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends CrudRepository <Ticket, Integer>{
    List<Ticket> findByUserId(int userid);
}
