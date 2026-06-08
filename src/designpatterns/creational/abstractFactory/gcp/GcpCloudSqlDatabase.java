package designpatterns.creational.abstractFactory.gcp;

import designpatterns.creational.abstractFactory.Database;

public class GcpCloudSqlDatabase implements Database {

    private String connectionName;

    public GcpCloudSqlDatabase(String connectionName){
        this.connectionName = connectionName;
    }

    @Override
    public void insert(String table, String record) {
        System.out.println("[CloudSQL] INSERT into " + table + ": " + record);
    }

    @Override
    public String query(String sql) {
        System.out.println("[CloudSQL] Executing: " + sql);
        return "CloudSQL result";
    }

    @Override
    public String getDbInfo() {
        return "GCP CloudSQL: " + connectionName;
    }
}
