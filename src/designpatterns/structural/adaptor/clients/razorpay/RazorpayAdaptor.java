package designpatterns.structural.adaptor.clients.razorpay;

import designpatterns.structural.adaptor.PaymentProcessor;
import designpatterns.structural.adaptor.PaymentResult;

import java.util.Map;

public class RazorpayAdaptor implements PaymentProcessor {

    private final RazorpayClient razorpay;

    public RazorpayAdaptor(String keyId, String keySecret) {
        this.razorpay = new RazorpayClient(keyId, keySecret);
    }

    @Override
    public PaymentResult pay(Double amount, String currency, String paymentToken) {

        long amountInPaise = (long)(amount * 100);

        String orderId = razorpay.createOrder(amountInPaise, currency);

        Map<String, String> response = razorpay.capturePayment(orderId, paymentToken);

        boolean success = "captured".equals(response.get("status"));
        return new PaymentResult(success, response.get("id"),
                success ? "Payment captured via Razorpay" : response.get("error"));
    }

    @Override
    public Boolean refund(String orderId, Double amount) {
        long amountInPaise = (long)(amount * 100);
        return razorpay.initiateRefund(orderId, amountInPaise);
    }
}
