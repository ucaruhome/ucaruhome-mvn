package com.ucuh.storage.model;

/**
 * Created by jzhu on 11/30/2015.
 */
public class FileStorageKey {
    private String key;     //key for aliyun OSS storage, similar to path
    private String path;    //path for local storage

    public FileStorageKey(String key, String path) {
        this.key = key;
        this.path = path;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
