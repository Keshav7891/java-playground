package designpatterns.creational.abstractFactory;

public interface CloudInfraFactory {
    Storage  createStorage();
    Database createDatabase();
    Cache    createCache();
}
