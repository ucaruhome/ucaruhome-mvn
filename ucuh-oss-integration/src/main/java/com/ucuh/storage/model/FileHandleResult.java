package com.ucuh.storage.model;

/**
 * Created by jzhu on 12/1/2015.
 */
public class FileHandleResult {
    String key;              //key for aliyun OSS storage, file path + file name
    String url;              //file/photo access URL
    Boolean success;         //flag indiates whether the upload is successfully
    String message;          //success info or error message if any

    public FileHandleResult() {
    }

    public FileHandleResult(FileStorageKey key) {
        this.key = key.getKey();
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
