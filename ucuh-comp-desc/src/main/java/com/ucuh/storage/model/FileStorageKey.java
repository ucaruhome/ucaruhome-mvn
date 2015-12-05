package com.ucuh.storage.model;

/**
 * Created by jzhu on 11/30/2015.
 */
public class FileStorageKey {
    private String key;     //key for aliyun OSS storage, file path + file name

    public FileStorageKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
