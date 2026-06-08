package lazySingleton;

public class LazySingleton {

    private static LazySingleton INSTANCE; // null until first call

    public static LazySingleton getInstance(){
        if (INSTANCE == null) {          // ← PROBLEM: Two threads can enter here simultaneously
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    }

    private LazySingleton(){
        System.out.println("lazySingleton created!");
    }

    public String showMessage(){
        return "Hello From lazySingleton.LazySingleton : " + hashCode();
    }

}
