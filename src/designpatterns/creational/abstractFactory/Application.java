package designpatterns.creational.abstractFactory;

public class Application {

    private Storage storage;
    private Cache cache;
    private Database database;

    public Application(CloudInfraFactory factory){
        this.database = factory.createDatabase();
        this.cache = factory.createCache();
        this.storage = factory.createStorage();
    }

    public void run(){
        database.getDbInfo();
        database.insert("USER", "INSERT INTO users (name, is_active) VALUES (\"Keshav\", 1)");
        database.query("SELECT * FROM users ORDER BY 1 DESC LIMIT 300");

        cache.getCacheInfo();
        cache.put("helloUser", "123");
        cache.get("helloUser");

        storage.getBucketInfo();
        storage.download("test.mp4");
        storage.upload("test.mp4", new byte[0]);
    }

}
