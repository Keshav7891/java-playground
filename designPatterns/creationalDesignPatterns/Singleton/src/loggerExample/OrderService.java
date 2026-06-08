package loggerExample;

public class OrderService {

    CustomSingletonLogger logger = CustomSingletonLogger.getLogger();

    public void placeOrder(String item){
        logger.info("Placing Order for Item : " + item);
    }

}
