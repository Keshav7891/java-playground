package eagerSingleton;

class EagerSingleton {

    private static final EagerSingleton INSTANCE = new EagerSingleton();

    public static EagerSingleton getInstance(){
        return INSTANCE;
    }

    private EagerSingleton(){
        System.out.println("eagerSingleton.EagerSingleton created!");
    }

    public String showMessage(){
        return "Hello From eagerSingleton.EagerSingleton : " + hashCode();
    }

}