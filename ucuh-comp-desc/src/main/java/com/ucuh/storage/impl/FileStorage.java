package com.ucuh.storage.impl;

import com.ucuh.storage.FileStorageIntfc;

/**
 * Created by jzhu on 11/30/2015.
 */
public abstract class FileStorage implements FileStorageIntfc {
        /**
         * @param path 更改路径的\杠
         * @return
         */
        @Deprecated
        protected String formatPath(String path) {
            return path.replace("\\", "/");
        }
}
