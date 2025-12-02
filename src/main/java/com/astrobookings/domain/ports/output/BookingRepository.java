package com.astrobookings.domain.ports.output;

import java.util.List;

import com.astrobookings.domain.models.Booking;

public interface BookingRepository {
    public List<Booking> findAll();
    public List<Booking> findByFlightId(String flightId);
    public List<Booking> findByPassengerName(String passengerName);
    public Booking save(Booking booking);
}
