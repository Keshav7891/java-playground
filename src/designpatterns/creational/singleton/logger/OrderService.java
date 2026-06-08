package designpatterns.creational.singleton.logger;

public class OrderService {

    private final SingletonLogger logger = SingletonLogger.getLogger();

    public void placeOrder(String item) {
        logger.info("Placing order for item: " + item);
    }
}
