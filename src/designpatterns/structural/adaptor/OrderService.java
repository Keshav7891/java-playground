package designpatterns.structural.adaptor;

public class OrderService {

    private final PaymentProcessor paymentProcessor;

    public OrderService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void placeOrder(String itemName, double price, String currency, String token) {
        System.out.println("\n--- Placing order: " + itemName + " (" + currency + " " + price + ") ---");

        PaymentResult result = paymentProcessor.pay(price, currency, token);

        if (result.isSuccess()) {
            System.out.println("Order confirmed. Transaction ID: " + result.getTransactionId());
            System.out.println(result.getMessage());
        } else {
            System.out.println("Order FAILED: " + result.getMessage());
        }
    }

    public void processRefund(String transactionId, double amount) {
        boolean refunded = paymentProcessor.refund(transactionId, amount);
        System.out.println("Refund " + (refunded ? "SUCCESS" : "FAILED") +
                " for txId: " + transactionId);
    }

}
