package designpatterns.creational.singleton.threadsafe;

public class SynchronizedSingleton {

    private static SynchronizedSingleton INSTANCE;

    private SynchronizedSingleton() {
        System.out.println("SynchronizedSingleton created!");
    }

    public static synchronized SynchronizedSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SynchronizedSingleton();
        }
        return INSTANCE;
    }

    public String showMessage() {
        return "Hello From SynchronizedSingleton : " + hashCode();
    }
}
