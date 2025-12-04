package com.astrobookings.sales.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.astrobookings.fleets.domain.models.Rocket;
//import com.astrobookings.fleets.domain.models.Rocket;
//import com.astrobookings.fleets.domain.ports.output.RocketRepository;
import com.astrobookings.sales.domain.models.CreateFlightCommand;
import com.astrobookings.sales.domain.models.Flight;
import com.astrobookings.sales.domain.models.FlightStatus;
import com.astrobookings.sales.domain.models.RocketInfo;
import com.astrobookings.sales.domain.ports.output.FlightRepository;
import com.astrobookings.sales.domain.ports.output.RocketsProvider;
import com.astrobookings.shared.models.BusinessErrorCode;
import com.astrobookings.shared.models.BusinessException;

public class FlightsService implements com.astrobookings.sales.domain.ports.input.FlightsUseCases {
  private final FlightRepository flightRepository;
  private final RocketsProvider rocketsPort;
  private static final int DEFAULT_MIN_PASSENGERS = 5;

  public FlightsService(FlightRepository flightRepository, RocketsProvider rocketsPort) {
    this.flightRepository = flightRepository;
    this.rocketsPort = rocketsPort;
  }

  public List<Flight> getFlights(String statusFilter) {
    if (statusFilter != null && !statusFilter.isEmpty()) {
      return flightRepository.findByStatus(statusFilter);
    } else {
      return flightRepository.findAll();
    }
  }

  public Flight createFlight(CreateFlightCommand command) {

    // Get Rocket for flight
    RocketInfo rocket = rocketsPort.findById(command.rocketId());

    Flight flight = new Flight();
    flight.setRocketInfo(rocket);
    flight.setDepartureDate(command.departureDate());
    flight.setBasePrice(command.basePrice());
    flight.setStatus(FlightStatus.SCHEDULED);
    flight.setMinPassengers(Math.max(command.minPassengers(), DEFAULT_MIN_PASSENGERS));

    flight.validate();

    return flightRepository.save(flight);
  }
}