package loggerExample;

public class Main {
    public static void main(String[] args) {
        OrderService o1 = new OrderService();
        PaymentService p1 = new PaymentService();

        o1.placeOrder("Keyboard");
        p1.processOrderPayment(0.0);
    }
}
