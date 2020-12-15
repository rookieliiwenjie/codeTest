package com.company.vmJ;

/**
 * Created by lwj32 on 2020/6/9.
 */
public class JvmDemo {
    public static void main(String[] args) {
      /*  ArrayList list=new ArrayList();

        while(true)

        {

            list.add(new JvmDemo());

        }*/
      long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("totalMemory = " + totalMemory+"M"+totalMemory/1024/1024);//64/1
      long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("maxMemory = " + maxMemory+"M"+maxMemory/1024/1024);//1/4

    }
}
