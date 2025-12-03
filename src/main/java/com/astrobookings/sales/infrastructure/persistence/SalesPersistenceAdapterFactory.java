package com.astrobookings.sales.infrastructure.persistence;

import com.astrobookings.sales.domain.ports.output.BookingRepository;
import com.astrobookings.sales.domain.ports.output.FlightRepository;
import com.astrobookings.sales.domain.ports.output.NotificationService;
import com.astrobookings.sales.domain.ports.output.PaymentGateway;
import com.astrobookings.sales.domain.ports.output.RocketsProvider;

public class SalesPersistenceAdapterFactory {
  private static final FlightRepository flightRepository = new FlightInMemoryRepository();
  private static final BookingRepository bookingRepository = new BookingInMemoryRepository();
  private static final PaymentGateway paymentGateway = new PaymentConsoleGateway();
  private static final NotificationService notificationService = new NotificationConsoleService();

  public static FlightRepository getFlightRepository() {
    return flightRepository;
  }

  public static BookingRepository getBookingRepository() {
    return bookingRepository;
  }

  public static PaymentGateway getPaymentGateway() {
    return paymentGateway;
  }

  public static NotificationService getNotificationService() {
    return notificationService;
  }
}
