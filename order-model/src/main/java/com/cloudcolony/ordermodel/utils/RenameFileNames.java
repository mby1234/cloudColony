package com.cloudcolony.ordermodel.utils;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @Author mby
 * @Description 对文件批量重命名
 * @Date 2018/6/16 14:35
 */
public class RenameFileNames {

    @Test
    public void renameFileNames() {
        System.out.println("开始运行");
        String path = "E:\\ucvideo"; // 要批量修改的文件所在的目录
        File file = new File(path);
        boolean isDirectory = file.isDirectory();
        if (!isDirectory) { // 如果不是文件夹，就返回
            System.out.println(path + "不是文件夹！");
            return;
        }
        String[] files = file.list();
        File f = null;
        String newFileName = ""; // 新的文件名字
        String oldFileName = ""; // 旧的文件名字
        for (int i = 0; i < files.length; i++) { // 遍历该文件夹下的所有文件
            oldFileName = files[i];
            newFileName = oldFileName.replace("vdat", "mp4");
            // 将修改后的文件保存在原目录下
            f = new File(path + "/" + oldFileName);
            f.renameTo(new File(path + "/" + newFileName));
        }
        System.out.println("修改完成");
    }

}
