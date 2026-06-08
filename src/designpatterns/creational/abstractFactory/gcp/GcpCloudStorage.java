package designpatterns.creational.abstractFactory.gcp;

import designpatterns.creational.abstractFactory.Storage;

public class GcpCloudStorage implements Storage {

    private String bucketName;

    public GcpCloudStorage(String bucketName){
        this.bucketName = bucketName;
    }

    @Override
    public void upload(String fileName, byte[] data) {
        System.out.println("[GCS] Uploading " + fileName + " to: " + bucketName);
    }

    @Override
    public byte[] download(String fileName) {
        System.out.println("[GCS] Downloading " + fileName);
        return new byte[0];
    }

    @Override
    public String getBucketInfo() {
        return "GCP Cloud Storage: " + bucketName;
    }
}
