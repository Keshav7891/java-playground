package designpatterns.creational.abstractFactory.aws;

import designpatterns.creational.abstractFactory.Storage;

public class AwsS3Bucket implements Storage {

    private String s3BucketName;

    public AwsS3Bucket(String s3BucketName){
        this.s3BucketName = s3BucketName;
    }


    @Override
    public void upload(String fileName, byte[] data) {
        System.out.println("[S3] Uploading " + fileName + " to bucket: " + s3BucketName);
    }

    @Override
    public byte[] download(String fileName) {
        System.out.println("[S3] Downloading " + fileName);
        return new byte[0];
    }

    @Override
    public String getBucketInfo() {
        return "AWS S3 bucket: " + s3BucketName;
    }
}
