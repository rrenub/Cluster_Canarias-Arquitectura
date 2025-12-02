package com.astrobookings.config;

import com.astrobookings.domain.BookingService;
import com.astrobookings.domain.FlightService;
import com.astrobookings.domain.RocketService;
import com.astrobookings.domain.ports.BookingRepository;
import com.astrobookings.domain.ports.BookingServiceContract;
import com.astrobookings.domain.ports.FlightRepository;
import com.astrobookings.domain.ports.FlightServiceContract;
import com.astrobookings.domain.ports.RocketRepository;
import com.astrobookings.domain.ports.RocketServiceContract;
import com.astrobookings.infrastructure.InMemoryBookingRepository;
import com.astrobookings.infrastructure.InMemoryFlightRepository;
import com.astrobookings.infrastructure.InMemoryRocketRepository;

public class AppFactory {

    public AppFactory(){}
    
    public RocketServiceContract createRocketService() {
        RocketRepository rocketRepository = new InMemoryRocketRepository();
        return new RocketService(rocketRepository);
    }

    public FlightServiceContract createFlightService() {
        FlightRepository flightRepository = new InMemoryFlightRepository();
        RocketRepository rocketRepository = new InMemoryRocketRepository();
        return new FlightService(flightRepository, rocketRepository);
    }

    public BookingServiceContract createBookingService() {
        FlightRepository flightRepository = new InMemoryFlightRepository();
        RocketRepository rocketRepository = new InMemoryRocketRepository();
        BookingRepository bookingRepository = new InMemoryBookingRepository();
        return new BookingService(bookingRepository, flightRepository, rocketRepository);
    }
}
