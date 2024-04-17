package com.company.Java.ClassLoaderDemo;

import lombok.SneakyThrows;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/14 4:21 下午
 * @Description:
 */
public class MyClassLoader extends ClassLoader {
    private String path;
    private String classLoaderName;

    public MyClassLoader(String path, String classLoaderName) {
        this.path = path;
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {

            byte[] b = loadClassData(name);
            return defineClass("com.company.Java.ClassLoaderDemo.Hello", b, 0, b.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private byte[] loadClassData(String name) throws IOException {
        name = path + name + ".class";
        InputStream is = null;
        ByteArrayOutputStream outputStream = null;
        try {
            is = new FileInputStream(new File(name));
            outputStream = new ByteArrayOutputStream();
            int i = 0;
            while ((i = is.read()) != -1) {
                outputStream.write(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
            if (is != null) {
                is.close();
            }
        }

        return outputStream.toByteArray();
    }
}
