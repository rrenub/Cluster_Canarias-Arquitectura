package com.astrobookings.domain.ports.input;

import java.util.List;

import com.astrobookings.domain.models.Flight;

public interface FlightUseCases {
    public List<Flight> getFlights(String statusFilter);
    public Flight createFlight(Flight flight);
}
