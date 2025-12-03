package com.astrobookings.sales.domain.ports.output;

import java.util.List;

import com.astrobookings.sales.domain.models.Flight;

public interface FlightRepository {
  List<Flight> findAll();

  Flight findById(String id);

  List<Flight> findByStatus(String status);

  Flight save(Flight flight);
}
