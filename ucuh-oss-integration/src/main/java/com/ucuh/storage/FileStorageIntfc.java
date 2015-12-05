package com.ucuh.storage;

import com.ucuh.storage.model.FileHandleResult;
import com.ucuh.storage.model.FileStorageKey;

import java.io.File;
import java.io.InputStream;

/**
 * Created by jzhu on 12/1/2015.
 */
public interface FileStorageIntfc {
    /**
     * delete file by FileStoragekey
     * @param storageKey
     * @return
     */
    FileHandleResult deleteFile(FileStorageKey storageKey);

    /**
     * upload file by specified storegeKey.key for Aliyun OSS or to storeageKey.path for local storage
     * @param storageKey
     * @param is
     * @return
     */
    FileHandleResult uploadFile(FileStorageKey storageKey, InputStream is);

    /**
     * upload file
     * @param storageKey
     * @param file
     * @return
     */
    FileHandleResult uploadFile(FileStorageKey storageKey, File file);

    /**
     * download file to specified path
     * @param storageKey
     * @param file
     * @return
     */
    FileHandleResult downloadFile(FileStorageKey storageKey, File file);
}
