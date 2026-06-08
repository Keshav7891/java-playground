package designpatterns.creational.factory;

public class Main {
    public static void main(String[] args) {
        DatabaseType postgresql = DatabaseType.POSTGRESQL;
        DatabaseConnection databaseConnection = ConnectionFactory.getDatabaseConnection(postgresql);
        databaseConnection.connect();
        databaseConnection.getConnectionInfo();
        databaseConnection.executeQuery("SELECT * FROM users ORDER BY 1 DESC LIMIT 300");
        databaseConnection.disconnect();
    }
}
