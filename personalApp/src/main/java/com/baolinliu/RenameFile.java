package com.baolinliu;

import java.io.File;

/**
 * @author richey
 */
public class RenameFile {

    public static void main(String[] args) {
        File file = new File("/home/richey/gitee/bf");
        renameFile(file, ".git.old", ".git");
    }


    public static void renameFile(File file, String oldName, String newName) {
        if (!file.exists()) {
            System.out.println("文件不存在!");
            return;
        }
        File[] files = file.listFiles();
        if (files.length == 0) {
            return;
        }
        for (File file2 : files) {
            String fileName = file2.getName();
            if (!file2.isDirectory()) {
                continue;
            }
            if (!fileName.equals(oldName)) {
                renameFile(file2, oldName, newName);
            } else {
                if (oldName.equals(fileName)) {
                    if (file2.renameTo(new File(file2.getParent(),newName))) {
                        System.out.println("修改成功------------" + oldName + "======>" + newName);
                    }else{
                        System.out.println("修改失败!");
                    }
                }
            }

        }
    }

}
