package designpatterns.structural.adaptor;

public interface PaymentProcessor {
    PaymentResult pay(Double amount, String currency, String paymentToken);
    Boolean refund(String orderId, Double amount);
}
