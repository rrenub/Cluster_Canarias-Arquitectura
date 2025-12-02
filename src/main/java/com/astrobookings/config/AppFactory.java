package com.astrobookings.config;

import com.astrobookings.domain.BookingService;
import com.astrobookings.domain.CancellationService;
import com.astrobookings.domain.FlightService;
import com.astrobookings.domain.RocketService;
import com.astrobookings.domain.ports.input.BookingUseCases;
import com.astrobookings.domain.ports.input.CancellationUseCases;
import com.astrobookings.domain.ports.input.FlightUseCases;
import com.astrobookings.domain.ports.input.RocketUseCases;
import com.astrobookings.domain.ports.output.BookingRepository;
import com.astrobookings.domain.ports.output.FlightRepository;
import com.astrobookings.domain.ports.output.Notification;
import com.astrobookings.domain.ports.output.PaymentGateway;
import com.astrobookings.domain.ports.output.RocketRepository;
import com.astrobookings.infrastructure.persistence.ExampleNotification;
import com.astrobookings.infrastructure.persistence.ExamplePaymentGateway;
import com.astrobookings.infrastructure.persistence.InMemoryBookingRepository;
import com.astrobookings.infrastructure.persistence.InMemoryFlightRepository;
import com.astrobookings.infrastructure.persistence.InMemoryRocketRepository;

public class AppFactory {

    private static final RocketRepository rocketRepository = new InMemoryRocketRepository();

    private static final FlightRepository flightRepository = new InMemoryFlightRepository();

    private static final BookingRepository bookingRepository = new InMemoryBookingRepository();

    private static final PaymentGateway paymentGateway = new ExamplePaymentGateway();

    private static final Notification notification = new ExampleNotification();

    public AppFactory(){}
    
    public RocketUseCases createRocketService() {
        return new RocketService(rocketRepository);
    }

    public FlightUseCases createFlightService() {
        return new FlightService(flightRepository, rocketRepository);
    }

    public BookingUseCases createBookingService() {
        return new BookingService(bookingRepository, flightRepository, rocketRepository, paymentGateway, notification);
    }

    public CancellationUseCases createCancellationService() {
        return new CancellationService(flightRepository, bookingRepository, paymentGateway, notification);
    }
}
