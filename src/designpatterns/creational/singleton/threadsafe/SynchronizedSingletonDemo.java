package designpatterns.creational.singleton.threadsafe;

public class SynchronizedSingletonDemo {

    public static void main(String[] args) {
        SynchronizedSingleton e1 = SynchronizedSingleton.getInstance();
        SynchronizedSingleton e2 = SynchronizedSingleton.getInstance();

        System.out.println(e1.showMessage());
        System.out.println(e2.showMessage());

        // Thread-safe | Slow — every call acquires a lock, even after instance is created
    }
}
