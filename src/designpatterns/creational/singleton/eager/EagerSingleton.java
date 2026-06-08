package designpatterns.creational.singleton.eager;

class EagerSingleton {

    private static final EagerSingleton INSTANCE = new EagerSingleton();

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }

    private EagerSingleton() {
        System.out.println("EagerSingleton created!");
    }

    public String showMessage() {
        return "Hello From EagerSingleton : " + hashCode();
    }
}
