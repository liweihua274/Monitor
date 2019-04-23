package com.adang.monitor.agent.plugins;


/**
 * created by liweihua 2019.4.10
 * 采集数据后下沉抽象类
 * 实现包括bolt传输，es，mysql，kafka等
 */
public abstract  class AbstractSinkPlugin implements Plugin {
    public void prepare() {

    }

    public void afterLoad() {

    }

    public String load() {
        return null;
    }

    public void shutdown() {

    }
}
