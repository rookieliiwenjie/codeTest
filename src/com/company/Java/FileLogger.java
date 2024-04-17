package com.company.Java;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/2 5:49 下午
 * @Description:
 */

// 抽象类的子类：输出日志到文件
public  class FileLogger extends Logger {
    private Writer fileWriter;

    public FileLogger(String name, boolean enabled,
                      Level minPermittedLevel, String filepath) {
        super(name, enabled, minPermittedLevel);
        try {
            this.fileWriter = new FileWriter(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doLog(Level level, String mesage) {
        // 格式化 level 和 message, 输出到日志文件
        try {
            System.out.println("level = " + level);
            fileWriter.write("...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
