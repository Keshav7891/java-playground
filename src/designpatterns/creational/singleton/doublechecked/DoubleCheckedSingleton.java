package designpatterns.creational.singleton.doublechecked;

public class DoubleCheckedSingleton {

    private static DoubleCheckedSingleton INSTANCE;

    private DoubleCheckedSingleton() {
        System.out.println("DoubleCheckedSingleton created!");
    }

    public static DoubleCheckedSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckedSingleton();
                }
            }
        }
        return INSTANCE;
    }

    public void connect(String db) {
        System.out.println("Connected to: " + db + " | instance: " + hashCode());
    }
}
