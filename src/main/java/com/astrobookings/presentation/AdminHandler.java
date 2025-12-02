package com.astrobookings.presentation;

import java.io.IOException;
import com.astrobookings.domain.ports.CancellationServiceContract;
import com.sun.net.httpserver.HttpExchange;

public class AdminHandler extends BaseHandler {
  private final CancellationServiceContract cancellationService;

  public AdminHandler(CancellationServiceContract cancellationService) {
    this.cancellationService = cancellationService;
  }

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    String method = exchange.getRequestMethod();

    if ("POST".equals(method)) {
      handlePost(exchange);
    } else {
      this.handleMethodNotAllowed(exchange);
    }
  }

  private void handlePost(HttpExchange exchange) throws IOException {
    String response = "";
    int statusCode = 200;

    try {
      response = cancellationService.cancelFlights();
    } catch (Exception e) {
      statusCode = 500;
      response = "{\"error\": \"Internal server error\"}";
    }

    sendResponse(exchange, statusCode, response);
  }
}