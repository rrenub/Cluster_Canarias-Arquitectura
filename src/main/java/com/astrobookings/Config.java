package com.astrobookings;

import com.astrobookings.fleets.domain.ports.input.RocketsUseCases;
import com.astrobookings.fleets.domain.ports.output.RocketRepository;
import com.astrobookings.fleets.infrastructure.persistence.FleetPersistenceAdapterFactory;
import com.astrobookings.fleets.infrastructure.presentation.FleetUseCasesAdapterFactory;
import com.astrobookings.sales.domain.ports.input.BookingsUseCases;
import com.astrobookings.sales.domain.ports.input.CancellationUseCases;
import com.astrobookings.sales.domain.ports.input.FlightsUseCases;
import com.astrobookings.sales.domain.ports.output.BookingRepository;
import com.astrobookings.sales.domain.ports.output.FlightRepository;
import com.astrobookings.sales.domain.ports.output.NotificationService;
import com.astrobookings.sales.domain.ports.output.PaymentGateway;
import com.astrobookings.sales.domain.ports.output.RocketsProvider;
import com.astrobookings.sales.infrastructure.persistence.RocketsAdapter;
import com.astrobookings.sales.infrastructure.persistence.SalesPersistenceAdapterFactory;
import com.astrobookings.sales.infrastructure.presentation.SalesUseCasesAdapterFactory;

public class Config {
  static final RocketRepository rocketRepository = FleetPersistenceAdapterFactory.getRocketRepository();
  static final FlightRepository flightRepository = SalesPersistenceAdapterFactory.getFlightRepository();
  static final BookingRepository bookingRepository = SalesPersistenceAdapterFactory.getBookingRepository();
  static final PaymentGateway paymentGateway = SalesPersistenceAdapterFactory.getPaymentGateway();
  static final NotificationService notificationService = SalesPersistenceAdapterFactory.getNotificationService();

  static final RocketsProvider rocketProvider = new RocketsAdapter(rocketRepository);

  static final RocketsUseCases rocketUseCase = FleetUseCasesAdapterFactory.getRocketsUseCase(rocketRepository);
  static final FlightsUseCases flightUseCase = SalesUseCasesAdapterFactory.getFlightsUseCase(
      flightRepository, rocketProvider);
  static final BookingsUseCases bookingUseCase = SalesUseCasesAdapterFactory.getBookingsUseCase(
      bookingRepository, flightRepository, rocketProvider,
      paymentGateway,
      notificationService);
  static final CancellationUseCases cancellationUseCases = SalesUseCasesAdapterFactory.getCancellationService(
      flightRepository, bookingRepository, paymentGateway, notificationService);

}
