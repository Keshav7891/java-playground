package designpatterns.creational.abstractFactory;

import designpatterns.creational.abstractFactory.aws.AwsInfraFactory;
import designpatterns.creational.abstractFactory.gcp.GcpInfraFactory;

public class InfraFactoryProvider {

    public static CloudInfraFactory getFactory(CloudProvider cloudProvider){
        return switch (cloudProvider){
            case AWS -> new AwsInfraFactory();
            case GCP -> new GcpInfraFactory();
        };
    }

}
