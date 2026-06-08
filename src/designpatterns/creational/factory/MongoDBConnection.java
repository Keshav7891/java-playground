package designpatterns.creational.factory;

public class MongoDBConnection implements DatabaseConnection{

    private String connectionString;

    public MongoDBConnection(String connectionString){
        this.connectionString = connectionString;
    }

    @Override
    public void connect() {
        System.out.println("Connecting to MongoDB: " + connectionString);
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnecting from MongoDB");
    }

    @Override
    public void executeQuery(String queryText) {
        System.out.println("[MongoDB] Running query/pipeline: " + queryText);
    }

    @Override
    public String getConnectionInfo() {
        return "MongoDB @ " + connectionString;
    }
}
