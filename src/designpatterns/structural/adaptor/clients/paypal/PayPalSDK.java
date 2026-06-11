package designpatterns.structural.adaptor.clients.paypal;

public class PayPalSDK {

    public PayPalSDK(String clientId, String clientSecret) {
        System.out.println("[PayPal SDK] Initialized");
    }

    // PayPal builds a Payment object, then executes it separately
    public String createPayment(String total, String currency, String description) {
        System.out.println("[PayPal] Creating payment: " + total + " " + currency);
        return "PAY-" + System.currentTimeMillis();    // PayPal payment ID
    }

    public boolean executePayment(String paymentId, String payerId) {
        System.out.println("[PayPal] Executing payment: " + paymentId + " payer: " + payerId);
        return true;
    }

    public boolean createRefund(String saleId, String total) {
        System.out.println("[PayPal] Refunding sale: " + saleId + " amount: " + total);
        return true;
    }
}
