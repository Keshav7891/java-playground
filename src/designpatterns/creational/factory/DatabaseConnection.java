package designpatterns.creational.factory;

public interface DatabaseConnection {
    void connect();
    void disconnect();
    void executeQuery(String queryText);
    String getConnectionInfo();
}
