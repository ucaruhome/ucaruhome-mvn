package com.ucuh.integration.oss.sample;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.AppendObjectRequest;
import com.aliyun.oss.model.AppendObjectResult;
import com.aliyun.oss.model.OSSObject;
import com.ucuh.integration.oss.OSSConfig;

import java.io.File;

/**
 * 该示例代码展示如何以追加的方式将文件或输入流写入到OSS。
 */
public class AppendObjectSample {

	private static final String ACCESS_ID = OSSConfig.ACCESS_KEY_ID;
	private static final String ACCESS_KEY = OSSConfig.ACCESS_KEY_SECRET;
	private static final String OSS_ENDPOINT = OSSConfig.OSS_ENDPOINT;

    public static void main(String[] args) throws Exception {
    	
    	String bucketName = "<your bucket name>";
    	String key = "<object name>";
    	
    	try {	
    		// 创建OSSClient实例
    		OSSClient client = new OSSClient(OSS_ENDPOINT, ACCESS_ID, ACCESS_KEY);
    		
    		// 发起首次追加Object请求，注意首次追加需要设置追加位置为0
    		final String fileToAppend = "<file to append at first time>";
    		AppendObjectRequest appendObjectRequest = new AppendObjectRequest(bucketName, key, new File(fileToAppend));
    		// 设置追加位置为0
    		appendObjectRequest.setPosition(0L);
    		AppendObjectResult appendObjectResult = client.appendObject(appendObjectRequest);

    		// 发起第二次追加Object请求，追加位置为第一次追加后的Object长度
    		final String fileToAppend2 = "<file to append at second time>";
    		appendObjectRequest = new AppendObjectRequest(bucketName, key, new File(fileToAppend2));
    		// 设置追加位置为前一次追加文件的大小
    		appendObjectRequest.setPosition(appendObjectResult.getNextPosition());
    		appendObjectResult = client.appendObject(appendObjectRequest);
    		OSSObject o = client.getObject(bucketName, key);
    		// 当前该Object的大小为两次追加文件的大小总和
    		System.out.println(o.getObjectMetadata().getContentLength());
    		// 下一个追加位置为前两次追加文件的大小总和
    		System.err.println(appendObjectResult.getNextPosition().longValue());
    	} catch (OSSException oe) {
    		System.out.println(oe.getMessage());
    	} catch (Exception e) {
    		
    	}
    }
}
