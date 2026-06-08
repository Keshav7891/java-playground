package designpatterns.creational.abstractFactory.gcp;

import designpatterns.creational.abstractFactory.Cache;

public class GcpMemorystore implements Cache {

    private String clusterEndpoint;

    public GcpMemorystore(String clusterEndpoint){
        this.clusterEndpoint = clusterEndpoint;
    }

    @Override
    public void put(String key, String value) {
        System.out.println("[MemoryStore] SET " + key + " = " + value);
    }

    @Override
    public String get(String key) {
        System.out.println("[MemoryStore] GET " + key);
        return "cached-value";
    }

    @Override
    public String getCacheInfo() {
        return "AWS MemoryStore: " + clusterEndpoint;
    }
}
