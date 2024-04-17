package com.company.Java.ClassLoaderDemo;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/14 8:26 下午
 * @Description:
 */
import sun.applet.Main;

import java.io.*;

public class MyFileClassLoader extends ClassLoader {
    private String directory;//被加载的类所在的目录

    /**
     * 指定要加载的类所在的文件目录
     * @param directory
     */
    public MyFileClassLoader(String directory){
//        super(parent);
        this.directory = directory;
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            //把类名转换为目录
            System.out.println(" ====== " );
            String file = directory+File.separator+name.replace(".", File.separator)+".class";
            //构建输入流
            InputStream in = new FileInputStream(file);
            //存放读取到的字节数据
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte buf[] = new byte[1024];
            int len = -1;
            while((len=in.read(buf))!=-1){
                baos.write(buf,0,len);
            }
            byte data[] = baos.toByteArray();
            in.close();
            baos.close();
            return defineClass(name,data,0,data.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        MyFileClassLoader myFileClassLoader = new MyFileClassLoader("/Users/liuyuhang/Downloads/liwenjie/codeTest/src");
        Class clazz = myFileClassLoader.loadClass("com.company.Java.ClassLoaderDemo.ClassLoaderDemo");
        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println("classLoader = " + classLoader);
        clazz.newInstance();
    }
}


