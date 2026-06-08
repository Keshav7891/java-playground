package designpatterns.creational.abstractFactory;

public interface Storage {
    void upload(String fileName, byte[] data);
    byte[] download(String fileName);
    String getBucketInfo();
}
