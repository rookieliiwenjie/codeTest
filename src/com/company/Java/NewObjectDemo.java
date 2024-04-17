package com.company.Java;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class NewObjectDemo implements Serializable {
    public static void main(String[] args) {
        NewObjectDemo newObjectDemo = new NewObjectDemo();
        Class clz = NewObjectDemo.class;
        Class superclass = clz.getSuperclass();
        try {
            Object o = superclass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //通过NewInstance
        try {
            NewObjectDemo newObjectDemo1 = (NewObjectDemo) clz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Class clss =  NewObjectDemo.class;
        Constructor constructor = null;
        try {
            constructor = clss.getConstructor();
            NewObjectDemo newObjectDemo1= (NewObjectDemo) constructor.newInstance();
            System.out.println("newObjectDemo1 = " + newObjectDemo1);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }catch (NoSuchMethodException e){
e.printStackTrace();
        }


//        try {
//            //5.通过对象的反序列化
//            FileInputStream fileInputStream = new FileInputStream("//Users//liuyuhang//Downloads//liwenjie//codeTest//src//com//company//Java//NewObjectDemo.java");
//            while (fileInputStream.available() > 0) {
//                ObjectInputStream ois = new ObjectInputStream(fileInputStream);
//                NewObjectDemo newObjectDemo = (NewObjectDemo) ois.readObject();
//                System.out.println("person1 = " + newObjectDemo);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }


    }


}
