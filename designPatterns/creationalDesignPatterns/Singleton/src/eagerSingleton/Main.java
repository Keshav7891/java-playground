package eagerSingleton;

public class Main {
    public static void main(String[] args){
        EagerSingleton e1 = EagerSingleton.getInstance();
        EagerSingleton e2 = EagerSingleton.getInstance();

        System.out.println(e1.showMessage());
        System.out.println(e2.showMessage());

        //✅ Simple, thread-safe | ❌ Instance created even if never used (wastes memory)
    }
}
