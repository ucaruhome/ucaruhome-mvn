package com.ucuh.integration.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.BucketReferer;
import com.aliyun.oss.model.ObjectMetadata;
import com.ucuh.storage.OSSClientFactory;
import com.ucuh.storage.model.FileHandleResult;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

/**
 * Created by jzhu on 11/13/2015.
 */
public class OSSConfig {
    private static Logger logger = Logger.getLogger(OSSConfig.class);
    public static String OSS_ENDPOINT = "http://oss.aliyuncs.com/";
    public static String OSS_DOMAIN = "aliyuncs.com";
    public static String ACCESS_KEY_ID = "tCaYCdhtTZ8mWUHJ";
    public static String ACCESS_KEY_SECRET = "kbcyf8fUAAjYKNTj5BDd1Chro0wgEl";
    public static String HTTP_PREFIX = "http://";
    public static String DOT = ".";
    public static String SLASH = "/";
    public static String UHOME_BUCKET_NAME = "uhomebucket001";

    private static OSSConfig instance = null;
    private static String uHomeBucketLocatino = null;


    //for test purpose
    public static String TEST_BUCKET_NAME = "uhomebucket-test";
    public static String TEST_OBJECT_KEY = "uhomeobject-test";


    private OSSConfig () {
    }

    public static OSSConfig getInstance () {
        synchronized (OSSConfig.class) {
            if (instance == null) {
                instance = new OSSConfig();
            }
        }
        return instance;
    }

    public String getBucketLocation () {
        if (uHomeBucketLocatino == null) {
            OSSClient client = OSSClientFactory.getInstance();
            String bucketName = OSSConfig.UHOME_BUCKET_NAME;
            try{
                uHomeBucketLocatino = client.getBucketLocation(bucketName);
            } catch(OSSException e){
                logger.error("Bucket location if not found: " + bucketName, e);
            }
        }
        return uHomeBucketLocatino;
    }
}
