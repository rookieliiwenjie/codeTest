package com.company.DemoFatory;

/**
 * @Author rookie.li
 * @create 2020/10/28
 */
public class FatoryMain {
    public static void main(String[] args) {
        String flag = "xiaomi";
        Father xiaomi = getMethed(flag);
        xiaomi.success();
        Father toutiao  = getMethed2("TOUTIAO");
        toutiao.success();
    }

    /**
     * 第一种方式，通过具体的标示确定具体实现方式
     * @param flag
     * @return
     */
    public static Father getMethed(String flag) {

        Father father = null;
        if ("toutiao".equals(flag)) {
            father = new ToutiaoDmeo();
        } else if ("xiaomi".equals(flag)) {
            father = new XiaoMiDemo();
        }
        return father;
    }

    /**
     * 第二种：定义枚举对应每一个工厂子类
     *       通过代理模式获取对应的子类
     * @param flag
     * @return
     */
    public static Father getMethed2(String flag) {
        FatherFatoryEnum fatherFatoryEnum = FatherFatoryEnum.match(flag);
        Father father = null;
        try {
            father = (Father) fatherFatoryEnum.clz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return father;
    }

}
