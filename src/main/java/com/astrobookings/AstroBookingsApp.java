package com.astrobookings;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.astrobookings.config.AppFactory;
import com.astrobookings.domain.ports.RocketRepository;
import com.astrobookings.domain.ports.RocketServiceContract;
import com.astrobookings.infrastructure.InMemoryRocketRepository;
import com.astrobookings.presentation.AdminHandler;
import com.astrobookings.presentation.BookingHandler;
import com.astrobookings.presentation.FlightHandler;
import com.astrobookings.presentation.RocketHandler;
import com.sun.net.httpserver.HttpServer;

public class AstroBookingsApp {
  public static void main(String[] args) throws IOException {
    // Create HTTP server on port 8080
    HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

    AppFactory appFactory = new AppFactory();

    // Create services
    RocketServiceContract rocketService = appFactory.createRocketService();

    // Register handlers for endpoints
    server.createContext("/rockets", new RocketHandler(rocketService));
    server.createContext("/flights", new FlightHandler());
    server.createContext("/bookings", new BookingHandler());
    server.createContext("/admin/cancel-flights", new AdminHandler());

    // Start server
    server.setExecutor(null); // Use default executor
    server.start();
    System.out.println("Server started at http://localhost:8080");
  }
}
