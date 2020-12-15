package com.company.DemoFatory;

/**
 * @Author rookie.li
 * @create 2020/10/29
 */
public enum FatherFatoryEnum {
    TOUTIAO("TOUTIAO", ToutiaoDmeo.class),
    XIAOMI("小米", XiaoMiDemo.class);
    public String desc;
    public Class<?> clz;

    FatherFatoryEnum(String desc, Class<?> clz) {
        this.desc = desc;
        this.clz = clz;
    }
    public static FatherFatoryEnum match(String flag) {
        FatherFatoryEnum[] enumDemo = FatherFatoryEnum.values();
        for (FatherFatoryEnum enumDemo1 : enumDemo) {
            if (flag.equals(enumDemo1.desc)) {
                return enumDemo1;
            }
        }
        return null;
    }

}
