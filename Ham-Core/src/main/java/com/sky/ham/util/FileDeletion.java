package com.sky.ham.util;

import java.io.File;

/**
 * @author Administrator
 */
public class FileDeletion {
    public static class FileHelper {
        public static void removeFile(String filePath) {
            if (filePath != null) {
                File file = new File(filePath);
                file.delete();
                System.out.println("删除成功" + file.getName());
            }
        }
    }
}
