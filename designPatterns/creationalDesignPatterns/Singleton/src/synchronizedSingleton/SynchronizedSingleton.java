package synchronizedSingleton;

public class SynchronizedSingleton {

    private static SynchronizedSingleton INSTANCE;

    private SynchronizedSingleton(){
        System.out.println("SynchronizedSingleton created!");
    }

    // 'synchronized' ensures only one thread enters at a time
    public static synchronized SynchronizedSingleton getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new SynchronizedSingleton();
        }
        return INSTANCE;
    }

    public String showMessage(){
        return "Hello From synchronizedSingleton.SynchronizedSingleton : " + hashCode();
    }

}
