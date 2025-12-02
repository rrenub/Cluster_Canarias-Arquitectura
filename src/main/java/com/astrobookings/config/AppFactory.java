package com.astrobookings.config;

import com.astrobookings.domain.BookingService;
import com.astrobookings.domain.CancellationService;
import com.astrobookings.domain.FlightService;
import com.astrobookings.domain.PaymentGateway;
import com.astrobookings.domain.RocketService;
import com.astrobookings.domain.ports.BookingRepository;
import com.astrobookings.domain.ports.BookingServiceContract;
import com.astrobookings.domain.ports.CancellationServiceContract;
import com.astrobookings.domain.ports.FlightRepository;
import com.astrobookings.domain.ports.FlightServiceContract;
import com.astrobookings.domain.ports.PaymentGatewayContract;
import com.astrobookings.domain.ports.RocketRepository;
import com.astrobookings.domain.ports.RocketServiceContract;
import com.astrobookings.infrastructure.InMemoryBookingRepository;
import com.astrobookings.infrastructure.InMemoryFlightRepository;
import com.astrobookings.infrastructure.InMemoryRocketRepository;

public class AppFactory {

    private static final RocketRepository rocketRepository = new InMemoryRocketRepository();

    private static final FlightRepository flightRepository = new InMemoryFlightRepository();

    private static final BookingRepository bookingRepository = new InMemoryBookingRepository();

    private static final PaymentGatewayContract paymentGateway = new PaymentGateway();

    public AppFactory(){}
    
    public RocketServiceContract createRocketService() {
        return new RocketService(rocketRepository);
    }

    public FlightServiceContract createFlightService() {
        return new FlightService(flightRepository, rocketRepository);
    }

    public BookingServiceContract createBookingService() {
        return new BookingService(bookingRepository, flightRepository, rocketRepository, paymentGateway);
    }

    public CancellationServiceContract createCancellationService() {
        return new CancellationService(flightRepository, bookingRepository, paymentGateway);
    }
}
