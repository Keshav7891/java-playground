package doubleCheckedSingleton;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            DoubleCheckedSingleton s = DoubleCheckedSingleton.getInstance();
            s.connect("POSTGRES");
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);
        Thread t4 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();

        //✅ Thread-safe ✅ Fast after initialization ✅ Lazy loaded

    }
}
