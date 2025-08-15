package com.company.shejimoshi.Singletenew;

public class SingleDemo {
    SingleDemo singleDemo;

    // 私有构造方法，防止外部实例化
    private SingleDemo() {
    }

    public SingleDemo getInstance() {
        synchronized (this) {
            if (singleDemo == null) {
                this.singleDemo = new SingleDemo();
                return singleDemo;
            }
        }

        return singleDemo;
    }
}
