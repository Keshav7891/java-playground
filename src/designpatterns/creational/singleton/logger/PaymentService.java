package designpatterns.creational.singleton.logger;

public class PaymentService {

    private final SingletonLogger logger = SingletonLogger.getLogger();

    public void processOrderPayment(double amount) {
        if (amount <= 0) {
            logger.error("Invalid transaction amount");
            return;
        }
        logger.info("Processing transaction: " + amount);
    }
}
