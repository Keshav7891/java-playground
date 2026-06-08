package designpatterns.creational.abstractFactory.aws;

import designpatterns.creational.abstractFactory.Database;

public class AwsRdsDatabase implements Database {

    private String connectionUrl;

    public AwsRdsDatabase(String connectionUrl){
        this.connectionUrl = connectionUrl;
    }

    @Override
    public void insert(String table, String record) {
        System.out.println("[RDS] INSERT into " + table + ": " + record);
    }

    @Override
    public String query(String sql) {
        System.out.println("[RDS] Executing: " + sql);
        return "Done Executing : " + sql;
    }

    @Override
    public String getDbInfo() {
        return "AWS RDS instance: " + connectionUrl;
    }
}
