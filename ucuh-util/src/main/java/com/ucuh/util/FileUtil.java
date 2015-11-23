package com.ucuh.util;

import java.io.File;

public class FileUtil {
    /**
     * @param path1 信息流中照片的访问路径
     */
    public static void delPhoto(String path1) {
        if (path1 != null && !"".equals(path1)) {
            String[] paths = path1.split("/");
            String fileName = paths[paths.length - 1];
            String wjj = paths[paths.length - 2];
            String userName = paths[paths.length - 3];
            //String path = ServletActionContext.getServletContext().getRealPath("/upload/"+userName+"/"+wjj);
            String path = "/upload/" + userName + "/" + wjj;
            String path2 = path + "\\" + fileName;
            File file = new File(path2);
            if (file.exists() && file.isFile()) {
                file.delete();
                //file.deleteOnExit();
            }
            File filewj = new File(path);
            if (filewj.exists()) {
                filewj.delete();
                //file.deleteOnExit();
            }
        }
    }

    /**
     * @param path  标签封面上传的文件路径
     * @param path1 标签封面的访问路径
     */
    public static void delLabel(String path, String path1) {
        if (path1 != null && !"".equals(path1)) {
            String[] paths = path1.split("/");
            String fileName = paths[paths.length - 1];
            String path2 = path + "\\" + fileName;
            File file = new File(path2);
            if (file.exists() && file.isFile()) {
                file.delete();
                //file.deleteOnExit();
            }
        }

    }

    /**
     * @param path 更改路径的\杠
     * @return
     */
    public static String changePath(String path) {
        String cpath = path.replace("\\", "/");
        return cpath;
    }
}
