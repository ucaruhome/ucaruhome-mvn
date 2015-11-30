package com.ucuh.integration.oss.sample;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.ucuh.integration.oss.OSSConfig;


public class ExampleForGetBucketLocation {
    private static final String ACCESS_ID = OSSConfig.ACCESS_KEY_ID;
    private static final String ACCESS_KEY = OSSConfig.ACCESS_KEY_SECRET;
    private static final String OSS_ENDPOINT = OSSConfig.OSS_ENDPOINT;
	public static void main(String [] args){
		OSSClient client=new OSSClient(OSS_ENDPOINT,ACCESS_ID,ACCESS_KEY);
		String bucketName = OSSConfig.BUCKET_NAME;
        try{
            String location = client.getBucketLocation(bucketName);
            System.out.println(location);
        }catch(OSSException e){
        	e.printStackTrace();
        }
	}
}
