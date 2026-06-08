package doubleCheckedSingleton;

public class DoubleCheckedSingleton {

    private static DoubleCheckedSingleton INSTANCE;

    private DoubleCheckedSingleton(){
        System.out.println("doubleCheckedSingleton.DoubleCheckedSingleton created!");
    }

    public static DoubleCheckedSingleton getInstance(){
        // two threads check if already not null
        if(INSTANCE == null){
            // if both threads find it null
            synchronized (DoubleCheckedSingleton.class){
                // one will enter and check if a previous thread made it not null or not
                if(INSTANCE == null){
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
