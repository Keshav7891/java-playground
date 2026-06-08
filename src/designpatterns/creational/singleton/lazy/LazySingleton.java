package designpatterns.creational.singleton.lazy;

public class LazySingleton {

    private static LazySingleton INSTANCE;

    public static LazySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }

    private LazySingleton() {
        System.out.println("LazySingleton created!");
    }

    public String showMessage() {
        return "Hello From LazySingleton : " + hashCode();
    }
}
