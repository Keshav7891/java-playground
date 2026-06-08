package designpatterns.creational.singleton.logger;

import java.time.LocalDateTime;

public class SingletonLogger {

    private static SingletonLogger INSTANCE;

    private SingletonLogger() {
        System.out.println("SingletonLogger initialized");
    }

    public static SingletonLogger getLogger() {
        if (INSTANCE == null) {
            synchronized (SingletonLogger.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonLogger();
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
