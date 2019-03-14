package com.adang.monitor.agent.store;


/**
 * 监控消息存储
 */
public interface MessageStore {

    void write();

    void batchWrite();

    void read();

    void batchRead();

    void flush();

    int size();

    void init();

    void destroy();


}
