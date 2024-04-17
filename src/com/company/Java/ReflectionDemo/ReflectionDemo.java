package com.company.Java.ReflectionDemo;

import com.company.javaEigt.Maohao.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * @Author: wenjie.li
 * @Date: 2023/6/7 7:56 下午
 * @Description:
 */
public class ReflectionDemo {

    public static void main(String[] args) {
        PersonDemo personDemo = new PersonDemo();
        personDemo.getClass().getAnnotations();
        Class aClass = personDemo.getClass();
        Class superclass = aClass.getSuperclass();
        System.out.println("superclass = " + superclass);
        Class superclass1 = superclass.getSuperclass();
        System.out.println("superclass1 = " + superclass1);
        Class superclass2 = superclass1.getSuperclass();
        System.out.println("superclass1 = " + superclass2);
        //获取名称
        String name = aClass.getName();
        System.out.println("name = " + name);
        // 获取类名
        String simpleName = aClass.getSimpleName();
        System.out.println("simpleName = " + simpleName);
        //
        Class[] classes = aClass.getClasses();
        System.out.println("classes = " + classes);
        //获取类加载器
        ClassLoader classLoader = aClass.getClassLoader();
        System.out.println("classLoader = " + classLoader);
//        ClassLoader classLoader1 = classLoader.getClass().getClassLoader();
//        System.out.println("classLoader1 = " + classLoader1);
//        ClassLoader classLoader2 = classLoader1.getClass().getClassLoader();
//        System.out.println("classLoader2 = " + classLoader2);

        //获取属性字
        Field[] fields = aClass.getFields();
        for (Field f : fields) {
            System.out.println("Field = " + f);
        }
        //获取所有字段名称 包括父類的
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field deFild:declaredFields) {
            System.out.println("deFild = " + deFild);
        }
        Class declaringClass = aClass.getDeclaringClass();
        System.out.println("declaringClass = " + declaringClass);
        Constructor[] constructors = aClass.getConstructors();
        System.out.println("constructors = " + constructors);
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
        }
        //获取lei'z
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method method:declaredMethods) {
            System.out.println("declaredMethods = " + method);
        }
//        ClassLoader classLoader1 = new ClassLoader() {
//            @Override
//            protected Class<?> loadClass(String name, boolean resolve)
//                    throws ClassNotFoundException
//            {  //加鎖操作
//                synchronized (getClassLoadingLock(name)) {
//                    // First, check if the class has already been loaded
//                    Class<?> c = findLoadedClass(name);
//                    if (c == null) {
//                        long t0 = System.nanoTime();
//                        try {
//                            if (parent != null) {
//                                c = parent.loadClass(name, false);
//                            } else {
//                                c = findBootstrapClassOrNull(name);
//                            }
//                        } catch (ClassNotFoundException e) {
//                            // ClassNotFoundException thrown if class not found
//                            // from the non-null parent class loader
//                        }
//
//                        if (c == null) {
//                            // If still not found, then invoke findClass in order
//                            // to find the class.
//                            long t1 = System.nanoTime();
//                            c = findClass(name);
//
//                            // this is the defining class loader; record the stats
//                            sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
//                            sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
//                            sun.misc.PerfCounter.getFindClasses().increment();
//                        }
//                    }
//                    if (resolve) {
//                        resolveClass(c);
//                    }
//                    return c;
//                }
//            }
//        }
//
//        AppClassLoader extClassLoader = new Extcla
    }


}
