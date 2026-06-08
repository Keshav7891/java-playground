package designpatterns.creational.abstractFactory.aws;

import designpatterns.creational.abstractFactory.Cache;
import designpatterns.creational.abstractFactory.CloudInfraFactory;
import designpatterns.creational.abstractFactory.Database;
import designpatterns.creational.abstractFactory.Storage;

public class AwsInfraFactory implements CloudInfraFactory {

    @Override
    public Storage createStorage() {
        return new AwsS3Bucket("my-app-bucket-prod");
    }

    @Override
    public Database createDatabase() {
        return new AwsRdsDatabase("myapp-rds-instance");
    }

    @Override
    public Cache createCache() {
        return new AwsElasticCache("myapp.cache.amazonaws.com");
    }
}