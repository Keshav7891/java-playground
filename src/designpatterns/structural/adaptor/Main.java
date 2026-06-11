package designpatterns.structural.adaptor;

import designpatterns.structural.adaptor.clients.razorpay.RazorpayAdaptor;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== Razorpay ==========");
        PaymentProcessor razorpayProcessor = new RazorpayAdaptor("rzp_live_key", "rzp_secret");
        OrderService rzpOrder = new OrderService(razorpayProcessor);
        rzpOrder.placeOrder("MacBook Pro", 199999.00, "INR", "tok_rzp_test_123");
        rzpOrder.processRefund("rzp_pay_987654", 199999.00);
    }
}
