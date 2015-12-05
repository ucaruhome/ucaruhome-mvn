package com.ucuh.test.storage.impl;

import com.ucuh.integration.oss.OSSConfig;
import com.ucuh.storage.impl.FileStorage;
import com.ucuh.storage.impl.OSSFileStorageImpl;
import com.ucuh.storage.model.FileHandleResult;
import com.ucuh.storage.model.FileStorageKey;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by jzhu on 12/5/2015.
 */
public class OSSFileStorageImplTest {

    @Test
    public void uploadFile() {
        printStartTs("uploadFile()");
        FileStorage fs = new OSSFileStorageImpl();
        System.out.println("Class URL: " + this.getClass().getResource("").toString());
        String fileName = "IMG_0135.JPG";
        FileStorageKey fsk = new FileStorageKey("OSSFileStorageImplTest/" + fileName);
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        FileHandleResult result = fs.uploadFile(fsk, is);
        System.out.println("OSS Url: " + result.getUrl());
        printEndTs("uploadFile()");
    }

    @Test
    public void downloadFile() {
        printStartTs("downloadFile()");
        FileStorage fs = new OSSFileStorageImpl();
        String fileName = "IMG_0134.JPG";
        FileStorageKey fsk = new FileStorageKey("OSSFileStorageImplTest/" + fileName);
        String newFileName = "IMG_0134_NEW.JPG";
        newFileName = getClass().getClassLoader().getResource("").getFile() + newFileName;
        System.out.println("newFileName: " + newFileName);
        FileHandleResult result = fs.downloadFile(fsk, new File(newFileName));
        printEndTs("downloadFile()");
    }

    @Test
    public void deleteFile() {
        System.out.println("---Test deleteFile() begin ---");
        FileStorage fs = new OSSFileStorageImpl();
        String fileName = "IMG_0134.JPG";
        FileStorageKey fsk = new FileStorageKey("OSSFileStorageImplTest/" + fileName);
        FileHandleResult result = fs.deleteFile(fsk);
        System.out.println("---Test deleteFile() end ---");
    }

    private void printStartTs (String methodName) {
        System.out.println(String.format("---Test " + methodName + " begin @%tT---", new Date()));
    }

    private void printEndTs (String methodName) {
        System.out.println(String.format("---Test " + methodName +  " end @%tT---", new Date()));
    }
}
