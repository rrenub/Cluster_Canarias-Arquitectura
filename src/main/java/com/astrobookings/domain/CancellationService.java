package com.astrobookings.domain;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.astrobookings.domain.models.Booking;
import com.astrobookings.domain.models.Flight;
import com.astrobookings.domain.models.FlightStatus;
import com.astrobookings.domain.ports.BookingRepository;
import com.astrobookings.domain.ports.CancellationServiceContract;
import com.astrobookings.domain.ports.FlightRepository;
import com.astrobookings.domain.ports.PaymentGatewayContract;

public class CancellationService implements CancellationServiceContract{
  private final FlightRepository flightRepository;
  private final BookingRepository bookingRepository;
  private final PaymentGatewayContract paymentGateway;

  public CancellationService(FlightRepository flightRepository, BookingRepository bookingRepository, PaymentGatewayContract paymentGateway) {
    this.flightRepository = flightRepository;
    this.bookingRepository = bookingRepository;
    this.paymentGateway = paymentGateway;
  }

  public String cancelFlights() throws Exception {
    List<Flight> flights = flightRepository.findAll();
    int cancelledCount = 0;
    LocalDateTime now = LocalDateTime.now();

    for (Flight flight : flights) {
      if (flight.getStatus() == FlightStatus.SCHEDULED) {
        long daysUntilDeparture = ChronoUnit.DAYS.between(now, flight.getDepartureDate());
        if (daysUntilDeparture <= 7) {
          List<Booking> bookings = bookingRepository.findByFlightId(flight.getId());
          if (bookings.size() < flight.getMinPassengers()) {
            // Cancel flight
            System.out.println("[CANCELLATION SERVICE] Cancelling flight " + flight.getId() + " - Only "
                + bookings.size() + "/5 passengers, departing in " + daysUntilDeparture + " days");
            flight.setStatus(FlightStatus.CANCELLED);
            flightRepository.save(flight);

            // Refund bookings
            for (Booking booking : bookings) {
              paymentGateway.processRefund(booking.getPaymentTransactionId(), booking.getFinalPrice());
            }

            // Notify
            NotificationService.notifyCancellation(flight.getId(), bookings);
            cancelledCount++;
          }
        }
      }
    }

    return "{\"message\": \"Flight cancellation check completed\", \"cancelledFlights\": " + cancelledCount + "}";
  }
}