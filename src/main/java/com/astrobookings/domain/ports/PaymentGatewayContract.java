package com.astrobookings.domain.ports;

public interface PaymentGatewayContract {
    public String processPayment(double amount) throws Exception;
    public void processRefund(String transactionId);
    public void processRefund(String transactionId, double amount);
}
