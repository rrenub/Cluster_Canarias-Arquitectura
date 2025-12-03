package com.astrobookings.sales.domain.ports.input;

import java.util.List;

import com.astrobookings.sales.domain.models.CreateFlightCommand;
import com.astrobookings.sales.domain.models.Flight;

public interface FlightsUseCases {
  List<Flight> getFlights(String statusFilter);

  Flight createFlight(CreateFlightCommand command);

}
