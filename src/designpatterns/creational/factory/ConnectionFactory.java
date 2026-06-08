package designpatterns.creational.factory;

import java.util.Map;

public class ConnectionFactory {

    private static final Map<DatabaseType, String> HOST_CONFIG = Map.of(
            DatabaseType.MYSQL, "mysql.prod.internal",
            DatabaseType.MONGODB, "mongodb://mongo.prod.internal:27017",
            DatabaseType.POSTGRESQL, "postgres.prod.internal"
    );

    public static DatabaseConnection getDatabaseConnection(DatabaseType type){
        return switch (type){
            case MYSQL -> new MySQLConnection(HOST_CONFIG.get(DatabaseType.MYSQL), 5432);
            case POSTGRESQL -> new PostgresConnection(HOST_CONFIG.get(DatabaseType.POSTGRESQL), "public");
            case MONGODB -> new MongoDBConnection(HOST_CONFIG.get(DatabaseType.MONGODB));
        };
    }

}
