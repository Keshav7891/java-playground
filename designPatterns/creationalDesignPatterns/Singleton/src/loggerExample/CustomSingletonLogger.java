package loggerExample;

import java.time.LocalDateTime;

public class CustomSingletonLogger {

    private static CustomSingletonLogger INSTANCE;

    private CustomSingletonLogger(){
        System.out.println("CustomSingletonLogger Initialized");
    }

    public static CustomSingletonLogger getLogger(){
        if(INSTANCE == null){
            synchronized (CustomSingletonLogger.class){
                if(INSTANCE == null){
                    INSTANCE = new CustomSingletonLogger();
                }
            }
        }
        return INSTANCE;
    }

    public void info(String message) {
        System.out.println("[INFO]  " + LocalDateTime.now() + " – " + message);
    }

    public void error(String message) {
        System.out.println("[ERROR] " + LocalDateTime.now() + " – " + message);
    }

    public void warn(String message) {
        System.out.println("[WARN]  " + LocalDateTime.now() + " – " + message);
    }


}
