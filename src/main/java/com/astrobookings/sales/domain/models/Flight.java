package com.astrobookings.sales.domain.models;

import java.time.LocalDateTime;

import com.astrobookings.shared.models.BusinessErrorCode;
import com.astrobookings.shared.models.BusinessException;

public class Flight {
  private String id;
  private RocketInfo rocket;
  private LocalDateTime departureDate;
  private double basePrice;
  private FlightStatus status;
  private int minPassengers;

  public Flight() {
  }

  public Flight(String id, RocketInfo rocket, LocalDateTime departureDate, double basePrice, FlightStatus status,
      int minPassengers) {
    this.id = id;
    this.rocket = rocket;
    this.departureDate = departureDate;
    this.basePrice = basePrice;
    this.status = status;
    this.minPassengers = minPassengers;
  }

  public void validate() throws IllegalArgumentException {
    if (this.rocket == null) {
      throw new BusinessException(BusinessErrorCode.NOT_FOUND, "Rocket for flight does not exists");
    }

    if (this.basePrice <= 0) {
      throw new BusinessException(BusinessErrorCode.VALIDATION, "Base price must be positive");
    }

    if (this.minPassengers <= 0 || this.minPassengers > 10) {
      throw new BusinessException(BusinessErrorCode.VALIDATION, "Min passengers must be between 1 and 10");
    }

    LocalDateTime now = LocalDateTime.now();
    if (!this.departureDate.isAfter(now)) {
      throw new BusinessException(BusinessErrorCode.VALIDATION, "Departure date must be in the future");
    }

    LocalDateTime oneYearAhead = now.plusYears(1);
    if (this.departureDate.isAfter(oneYearAhead)) {
      throw new BusinessException(BusinessErrorCode.VALIDATION, "Departure date cannot be more than 1 year ahead");
    }
  }

  // Getter & Setters

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public RocketInfo getRocketInfo() {
    return rocket;
  }

  public void setRocketInfo(RocketInfo rocket) {
    this.rocket = rocket;
  }

  public LocalDateTime getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(LocalDateTime departureDate) {
    this.departureDate = departureDate;
  }

  public double getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(double basePrice) {
    this.basePrice = basePrice;
  }

  public FlightStatus getStatus() {
    return status;
  }

  public void setStatus(FlightStatus status) {
    this.status = status;
  }

  public int getMinPassengers() {
    return minPassengers;
  }

  public void setMinPassengers(int minPassengers) {
    this.minPassengers = minPassengers;
  }
}