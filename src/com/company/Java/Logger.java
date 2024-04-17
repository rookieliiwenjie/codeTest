package com.company.Java;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/2 5:46 下午
 * @Description:
 */
public abstract class Logger {

    public static void main(String[] args) {
        Logger logger = new FileLogger("ddd", true, Level.FINE, ".....");
        logger.doLog(Level.FINE, "ee");
    }

    // 抽象类
    private String name;
    private boolean enabled;
    private Level minPermittedLevel;

    public Logger(String name, boolean enabled, Level minPermittedLevel) {
        this.name = name;
        this.enabled = enabled;
        this.minPermittedLevel = minPermittedLevel;
    }

    public void log(Level level, String message) {
        //这里还有一些公共方法的特殊处理
        boolean loggable = enabled && (minPermittedLevel.intValue() <= level.intValue());
        if (!loggable) return;
        doLog(level, message);
    }

    protected abstract void doLog(Level level, String message);


}
