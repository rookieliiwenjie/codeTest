package com.company.javaEigt.JavaEightDemo.chapterOne;

import java.io.File;
import java.io.FileFilter;

/**
 * @Author: wenjie.li
 * @Date: 2022/8/2 12:27 上午
 * @Description:
 */
public class FileDemo {
    public static void main(String[] args) {
        File[] file = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });
        for (int i = 0; i < file.length; i++) {
            System.out.println("file = " + file[i]);

        }
        //java 8 新特性，：： 语法把方法作为值，将其传递给listFiles
        File[] files = new File(".").listFiles(File::isHidden);
        for (int i = 0; i < files.length; i++) {
            System.out.println("files = " + files[i]);
        }

    }
}
