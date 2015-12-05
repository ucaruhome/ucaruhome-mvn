package com.ucuh.storage.impl;


import com.aliyun.oss.*;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.ucuh.integration.oss.OSSConfig;
import com.ucuh.storage.OSSClientFactory;
import com.ucuh.storage.model.FileStorageKey;
import com.ucuh.storage.model.FileHandleResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by jzhu on 11/30/2015.
 */
public class OSSFileStorageImpl extends FileStorage {
    @Override
    public FileHandleResult uploadFile(FileStorageKey storageKey, InputStream input) {
        FileHandleResult result = new FileHandleResult(storageKey);
        OSSClient client = OSSClientFactory.getInstance();
        String bucketName = OSSConfig.UHOME_BUCKET_NAME;
        ObjectMetadata objectMeta = new ObjectMetadata();
        // 可以在metadata中标记文件类型
        objectMeta.setContentType("image/jpeg");
        //ensure bucket is already created
        ensureBucket(client, bucketName);
        //put object to OSS
        client.putObject(bucketName, storageKey.getKey(), input, objectMeta);
        result.setSuccess(Boolean.TRUE);
        //constructOSSUrl
        constructOSSUrl(bucketName, result);
        return result;
    }

    @Override
    public FileHandleResult uploadFile(FileStorageKey storageKey, File file) {
        FileHandleResult result = new FileHandleResult(storageKey);
        OSSClient client = OSSClientFactory.getInstance();
        String bucketName = OSSConfig.UHOME_BUCKET_NAME;
        ObjectMetadata objectMeta = new ObjectMetadata();
        objectMeta.setContentLength(file.length());
        // 可以在metadata中标记文件类型
        objectMeta.setContentType("image/jpeg");
        //ensure bucket is already created
        ensureBucket(client, bucketName);
        InputStream input = null;
        try {
            input = new FileInputStream(file);
            client.putObject(bucketName, storageKey.getKey(), input, objectMeta);
            result.setSuccess(Boolean.TRUE);
            //constructOSSUrl
            constructOSSUrl(bucketName, result);
        } catch (FileNotFoundException e) {
            result.setMessage(e.getMessage());
            result.setSuccess(Boolean.FALSE);
        }
        return result;
    }

    @Override
    public FileHandleResult downloadFile(FileStorageKey storageKey, File file) {
        FileHandleResult result = new FileHandleResult(storageKey);
        OSSClient client = OSSClientFactory.getInstance();
        String bucketName = OSSConfig.UHOME_BUCKET_NAME;
        client.getObject(new GetObjectRequest(bucketName, storageKey.getKey()), file);
        result.setSuccess(Boolean.TRUE);
        return result;
    }

    @Override
    public FileHandleResult deleteFile(FileStorageKey storageKey) {
        FileHandleResult result = new FileHandleResult(storageKey);
        OSSClient client = OSSClientFactory.getInstance();
        String bucketName = OSSConfig.UHOME_BUCKET_NAME;
        client.deleteObject(bucketName, storageKey.getKey());
        result.setSuccess(Boolean.TRUE);
        return result;
    }

    // 创建Bucket.
    private void ensureBucket(OSSClient client, String bucketName)
            throws OSSException, ClientException {
        Bucket bucket = null;
        try {
            // 创建bucket
            bucket = client.createBucket(bucketName);
        } catch (ServiceException e) {
            if (!OSSErrorCode.BUCKET_ALREADY_EXISTS.equals(e.getErrorCode())) {
                // 如果Bucket已经存在，则忽略
                throw e;
            }
        }
        client.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
    }

    /**
     * consutruct the OSS access URL for photo
     * @param bucketName
     * @param result
     * @return http://uhomebucket001.oss-cn-hangzhou.aliyuncs.com/OSSFileStorageImplTest/IMG_0134.JPG
     */
    private String constructOSSUrl(String bucketName, FileHandleResult result) {
        StringBuffer urlStrB = new StringBuffer(OSSConfig.HTTP_PREFIX);
        urlStrB.append(bucketName).append(OSSConfig.DOT);
        urlStrB.append(OSSConfig.getInstance().getBucketLocation()).append(OSSConfig.DOT);
        urlStrB.append(OSSConfig.OSS_DOMAIN).append(OSSConfig.SLASH);
        urlStrB.append(result.getKey());

        String url = urlStrB.toString();
        result.setUrl(url);;
        return url.toString();
    }
}
