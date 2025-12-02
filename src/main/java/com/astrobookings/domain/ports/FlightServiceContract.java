package com.astrobookings.domain.ports;

import java.util.List;

import com.astrobookings.domain.models.Flight;

public interface FlightServiceContract {
    public List<Flight> getFlights(String statusFilter);
    public Flight createFlight(Flight flight);
}
