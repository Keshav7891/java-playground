package designpatterns.creational.abstractFactory.aws;

import designpatterns.creational.abstractFactory.Cache;

public class AwsElasticCache implements Cache {

    private String clusterEndpoint;

    public AwsElasticCache(String clusterEndpoint){
        this.clusterEndpoint = clusterEndpoint;
    }

    @Override
    public void put(String key, String value) {
        System.out.println("[ElastiCache] SET " + key + " = " + value);
    }

    @Override
    public String get(String key) {
        System.out.println("[ElastiCache] GET " + key);
        return "cached-value";
    }

    @Override
    public String getCacheInfo() {
        return "AWS ElastiCache: " + clusterEndpoint;
    }
}
