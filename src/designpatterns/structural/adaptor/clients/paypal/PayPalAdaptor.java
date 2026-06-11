package designpatterns.structural.adaptor.clients.paypal;

import designpatterns.structural.adaptor.PaymentProcessor;
import designpatterns.structural.adaptor.PaymentResult;

public class PayPalAdaptor implements PaymentProcessor {

    private final PayPalSDK paypal;

    public PayPalAdaptor(String clientId, String clientSecret) {
        this.paypal = new PayPalSDK(clientId, clientSecret);
    }

    @Override
    public PaymentResult pay(Double amount, String currency, String paymentToken) {
        String total = String.format("%.2f", amount);
        String paymentId = paypal.createPayment(total, currency, "Order payment");
        boolean success  = paypal.executePayment(paymentId, paymentToken);

        return new PaymentResult(success, paymentId,
                success ? "Payment executed via PayPal" : "PayPal execution failed");
    }

    @Override
    public Boolean refund(String orderId, Double amount) {
        String total = String.format("%.2f", amount);
        return paypal.createRefund(orderId, total);
    }
}
