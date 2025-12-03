package com.astrobookings;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.astrobookings.fleets.infrastructure.presentation.RocketsHandler;
import com.astrobookings.sales.infrastructure.presentation.AdminHandler;
import com.astrobookings.sales.infrastructure.presentation.BookingsHandler;
import com.astrobookings.sales.infrastructure.presentation.FlightsHandler;
import com.sun.net.httpserver.HttpServer;

public class AstroBookingsApp {
  public static void main(String[] args) throws IOException {
    // Create HTTP server on port 8080
    HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

    // Register handlers for endpoints
    server.createContext("/rockets", new RocketsHandler(Config.rocketUseCase));
    server.createContext("/flights", new FlightsHandler(Config.flightUseCase));
    server.createContext("/bookings", new BookingsHandler(Config.bookingUseCase));
    server.createContext("/admin/cancel-flights", new AdminHandler(Config.cancellationUseCases));

    // Start server
    server.setExecutor(null); // Use default executor
    server.start();
    System.out.println("Server started at http://localhost:8080");
  }
}