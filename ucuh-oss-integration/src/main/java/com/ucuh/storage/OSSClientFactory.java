package com.ucuh.storage;

import com.aliyun.oss.OSSClient;
import com.ucuh.integration.oss.OSSConfig;

/**
 * Created by jzhu on 12/1/2015.
 */
public class OSSClientFactory {
    private static OSSClient client;

    /**
     * Fetch Aliyun OSSClient
     * @return
     */
    public static OSSClient getInstance() {
        synchronized (OSSClientFactory.class) {
            if (client == null) {
                final String ACCESS_ID = OSSConfig.ACCESS_KEY_ID;
                final String ACCESS_KEY = OSSConfig.ACCESS_KEY_SECRET;
                final String OSS_ENDPOINT = OSSConfig.OSS_ENDPOINT;
                client = new OSSClient(OSS_ENDPOINT,ACCESS_ID, ACCESS_KEY);
            }
        }
        return client;
    }
}
