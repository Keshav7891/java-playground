package designpatterns.creational.factory;

public class MySQLConnection implements DatabaseConnection{

    private String host;
    private Integer port;

    public MySQLConnection(String host, Integer port){
        this.host = host;
        this.port = port;
    }

    @Override
    public void connect() {
        System.out.println("Connecting to MySQL at " + host + ":" + port);
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnecting from MySQL");
    }

    @Override
    public void executeQuery(String queryText) {
        System.out.println("[MySQL] Executing: " + queryText);
    }

    @Override
    public String getConnectionInfo() {
        return "MySQL @ " + host + ":" + port;
    }
}
