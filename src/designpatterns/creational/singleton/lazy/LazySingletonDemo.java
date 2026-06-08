package designpatterns.creational.singleton.lazy;

public class LazySingletonDemo {

    public static void main(String[] args) {
        LazySingleton e1 = LazySingleton.getInstance();
        LazySingleton e2 = LazySingleton.getInstance();

        System.out.println(e1.showMessage());
        System.out.println(e2.showMessage());

        // Created only when needed | Not thread-safe — broken in multi-threaded apps
    }
}
