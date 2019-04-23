package com.adang.monitor.agent.plugins;


import com.adang.monitor.agent.collector.disruptor.DisruptorHandler;

/**
 * created by liweihua 2019.4.10
 * 采集端插件抽象类
 */
public  abstract  class AbstractCollectorPlugin  implements Plugin{

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
