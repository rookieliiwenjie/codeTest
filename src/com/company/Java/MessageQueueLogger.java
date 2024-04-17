package com.company.Java;

import java.util.logging.Level;

/**
 * @Author: wenjie.li
 * @Date: 2023/6/2 5:51 下午
 * @Description:
 */
// 抽象类的子类: 输出日志到消息中间件 (比如 kafka)
public class MessageQueueLogger extends Logger {
    private MessageQueueClient msgQueueClient;

    public MessageQueueLogger(String name, boolean enabled,
                              Level minPermittedLevel, MessageQueueClient msgQueueClient) {
        super(name, enabled, minPermittedLevel);
        this.msgQueueClient = msgQueueClient;
    }
    @Override
    protected void doLog(Level level, String mesage) {
        // 格式化 level 和 message, 输出到消息中间件
        msgQueueClient.send("...");
    }
}
