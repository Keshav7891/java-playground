package designpatterns.creational.abstractFactory;

public interface Database {
    void insert(String table, String record);
    String query(String sql);
    String getDbInfo();
}
