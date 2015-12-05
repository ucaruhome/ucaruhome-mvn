package com.ucuh.storage;

import com.ucuh.storage.impl.FileStorage;
import com.ucuh.storage.model.FileStorageKey;
import com.ucuh.storage.model.FileHandleResult;

import java.io.File;
import java.io.InputStream;

public class LocalFileStorageImpl extends FileStorage {

    @Override
    public FileHandleResult deleteFile(FileStorageKey key) {
        //TODO
        return null;
    }

    @Override
    public FileHandleResult uploadFile(FileStorageKey key, InputStream is) {
        //TODO
        return null;
    }

    @Override
    public FileHandleResult uploadFile(FileStorageKey key, File file) {
        //TODO
        return null;
    }

    @Override
    public FileHandleResult downloadFile(FileStorageKey key, File file) {
        //TODO
        return null;
    }
}
