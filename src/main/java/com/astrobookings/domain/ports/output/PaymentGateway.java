package com.astrobookings.domain.ports.output;

public interface PaymentGateway {
    public String processPayment(double amount) throws Exception;
    public void processRefund(String transactionId);
    public void processRefund(String transactionId, double amount);
}
