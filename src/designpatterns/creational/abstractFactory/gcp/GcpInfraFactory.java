package designpatterns.creational.abstractFactory.gcp;

import designpatterns.creational.abstractFactory.Cache;
import designpatterns.creational.abstractFactory.CloudInfraFactory;
import designpatterns.creational.abstractFactory.Database;
import designpatterns.creational.abstractFactory.Storage;

public class GcpInfraFactory implements CloudInfraFactory {

    @Override
    public Storage createStorage() {
        return new GcpCloudStorage("myapp-gcs-bucket");
    }

    @Override
    public Database createDatabase() {
        return new GcpCloudSqlDatabase("project:region:myapp-db");
    }

    @Override
    public Cache createCache() {
        return new GcpMemorystore("10.0.0.4");
    }
}