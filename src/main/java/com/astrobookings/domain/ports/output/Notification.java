package com.astrobookings.domain.ports.output;

import java.util.List;

import com.astrobookings.domain.models.Booking;

public interface Notification {
    public void notifyConfirmation(String flightId, int passengerCount);
    public void notifyCancellation(String flightId, int passengerCount);
    public void notifyCancellation(String flightId, List<Booking> bookings);
}
