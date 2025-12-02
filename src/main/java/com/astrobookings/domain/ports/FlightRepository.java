package com.astrobookings.domain.ports;

import java.util.List;

import com.astrobookings.infrastructure.models.Flight;

public interface FlightRepository {
    public List<Flight> findAll();
    public List<Flight> findByStatus(String status);
    public Flight save(Flight flight);
}
