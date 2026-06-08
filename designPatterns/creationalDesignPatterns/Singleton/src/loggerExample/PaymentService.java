package loggerExample;

public class PaymentService {

    CustomSingletonLogger logger = CustomSingletonLogger.getLogger();

    public void processOrderPayment(Double amount){
        if(amount <= 0){
            logger.error("Invalid transaction amount");
            return;
        }
        logger.info("Processing transaction : " + amount);
    }

}
