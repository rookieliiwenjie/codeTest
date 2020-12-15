package com.company;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author rookie.li
 * @create 2020/10/27
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
    public EnumDemo EnumDemo() default EnumDemo.FRIST;

    public String neii() default "";

    public enum EnumDemo {
        FRIST(1, "第一"),
        TWO(2, "第二");
        private int type;
        private String name;

        private EnumDemo(int type, String name) {
            this.type = type;
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
