package com.ticketsales.services;

import com.ticketsales.model.Flight;
import com.ticketsales.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class FlightImplement implements FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Override
    public List<Flight> getAllFlights() {
        return (List<Flight>) flightRepository.findAll();
    }

    @Override
    public Flight getFlightById(int id) {
        return flightRepository.findById(id).get();
    }

    @Override
    public void addFlight(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(int id) {
        flightRepository.deleteById(id);
    }

    @Override
    public Flight updateFlight(Flight flight1, int id) {
        flightRepository.deleteById(id);
        Flight flight = flightRepository.save(flight1);

        return flight;
    }
}

