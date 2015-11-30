package com.ucuh.integration.oss.sample;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.AccessControlList;
import com.aliyun.oss.model.CannedAccessControlList;
import com.ucuh.integration.oss.OSSConfig;


public class ExampleForBucketAcl {
	private static final String ACCESS_ID = OSSConfig.ACCESS_KEY_ID;
	private static final String ACCESS_KEY = OSSConfig.ACCESS_KEY_SECRET;
	private static final String OSS_ENDPOINT = OSSConfig.OSS_ENDPOINT;
	public static void main(String [] args){
		OSSClient client = new OSSClient(OSS_ENDPOINT, ACCESS_ID, ACCESS_KEY);
		String bucketName = "<your bucket name>";
		client.setBucketAcl(bucketName, CannedAccessControlList.PublicReadWrite); 
		AccessControlList accessControlList = client.getBucketAcl(bucketName);
		//可以打印出来看结果,也可以从控制台确认
		System.out.println(accessControlList.toString());
	}
}

