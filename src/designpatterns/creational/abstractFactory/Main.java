package designpatterns.creational.abstractFactory;

public class Main {
    public static void main(String[] args) {
        CloudProvider aws = CloudProvider.AWS;
        CloudInfraFactory factory = InfraFactoryProvider.getFactory(aws);
        Application app = new Application(factory);
        app.run();
    }

}
