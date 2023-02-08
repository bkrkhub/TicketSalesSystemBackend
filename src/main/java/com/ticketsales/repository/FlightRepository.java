package com.ticketsales.repository;

import com.ticketsales.model.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository <Flight, Integer>{

}