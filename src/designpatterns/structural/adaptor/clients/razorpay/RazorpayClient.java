package designpatterns.structural.adaptor.clients.razorpay;

import java.util.Map;

public class RazorpayClient {

    public RazorpayClient(String keyId, String keySecret) {
        System.out.println("[Razorpay SDK] Initialized with key: " + keyId);
    }

    public String createOrder(long amountInPaise, String currency) {
        System.out.println("[Razorpay] Creating order: " + amountInPaise + " paise, " + currency);
        return "rzp_order_" + System.currentTimeMillis();
    }

    public Map<String, String> capturePayment(String orderId, String token) {
        System.out.println("[Razorpay] Capturing payment for order: " + orderId);
        return java.util.Map.of(
                "status", "captured",
                "id", "rzp_pay_" + System.nanoTime(),
                "error", ""
        );
    }

    public boolean initiateRefund(String paymentId, long amountInPaise) {
        System.out.println("[Razorpay] Refunding " + amountInPaise + " paise for: " + paymentId);
        return true;
    }

}
