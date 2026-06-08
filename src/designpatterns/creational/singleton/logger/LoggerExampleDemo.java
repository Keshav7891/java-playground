package designpatterns.creational.singleton.logger;

public class LoggerExampleDemo {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        PaymentService paymentService = new PaymentService();

        orderService.placeOrder("Keyboard");
        paymentService.processOrderPayment(0.0);
    }
}
