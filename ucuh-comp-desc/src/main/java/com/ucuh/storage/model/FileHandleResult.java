package com.ucuh.storage.model;

/**
 * Created by jzhu on 12/1/2015.
 */
public class FileHandleResult {
    String key;              //key for aliyun OSS storage
    String path;             //path for local storage
    String url;              //file/photo access URL
    Boolean success;         //flag indiates whether the upload is successfully
    String message;          //success info or error message if any

    public FileHandleResult() {
    }

    public FileHandleResult(FileStorageKey key) {
        this.key = key.getKey();
        this.path = key.getPath();
    }

    public FileHandleResult(String key, String path) {
        this.key = key;
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
