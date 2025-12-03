package com.astrobookings.sales.infrastructure.presentation;

import com.astrobookings.fleets.domain.ports.output.RocketRepository;
import com.astrobookings.sales.domain.BookingsService;
import com.astrobookings.sales.domain.CancellationService;
import com.astrobookings.sales.domain.FlightsService;
import com.astrobookings.sales.domain.ports.input.BookingsUseCases;
import com.astrobookings.sales.domain.ports.input.FlightsUseCases;
import com.astrobookings.sales.domain.ports.output.BookingRepository;
import com.astrobookings.sales.domain.ports.output.FlightRepository;
import com.astrobookings.sales.domain.ports.output.NotificationService;
import com.astrobookings.sales.domain.ports.output.PaymentGateway;

public class SalesUseCasesAdapterFactory {
    public static FlightsUseCases getFlightsUseCase(FlightRepository flightRepository,
      RocketRepository rocketRepository) {
        return new FlightsService(flightRepository, rocketRepository);
  }

  public static BookingsUseCases getBookingsUseCase(BookingRepository bookingRepository,
      FlightRepository flightRepository,
      RocketRepository rocketRepository,
      PaymentGateway paymentGateway,
      NotificationService notificationService) {
    return new BookingsService(
        bookingRepository,
        flightRepository,
        rocketRepository,
        paymentGateway,
        notificationService);
  }

  public static CancellationService getCancellationService(FlightRepository flightRepository,
      BookingRepository bookingRepository,
      PaymentGateway paymentGateway,
      NotificationService notificationService) {
    return new CancellationService(
        flightRepository,
        bookingRepository,
        paymentGateway,
        notificationService);
  }
}
