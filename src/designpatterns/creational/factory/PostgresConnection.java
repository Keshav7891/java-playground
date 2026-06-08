package designpatterns.creational.factory;

public class PostgresConnection implements DatabaseConnection{

    private String host;
    private String schema;

    public PostgresConnection(String host, String schema){
        this.host = host;
        this.schema = schema;
    }

    @Override
    public void connect() {
        System.out.println("Connecting to PostgreSQL at " + host + ", schema: " + schema);
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnecting from PostgreSQL");
    }

    @Override
    public void executeQuery(String queryText) {
        System.out.println("[PostgreSQL] Executing: " + queryText);
    }

    @Override
    public String getConnectionInfo() {
        return "PostgreSQL @ " + host + " / schema: " + schema;
    }
}
