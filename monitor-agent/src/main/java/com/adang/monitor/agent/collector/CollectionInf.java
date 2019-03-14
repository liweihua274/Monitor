package com.adang.monitor.agent.collector;

/**
 * 数据采集接口
 */
public interface CollectionInf {

    void collect();

    void read();

    void write();

    void size();

    void clear();

    boolean isCollecting();


}
