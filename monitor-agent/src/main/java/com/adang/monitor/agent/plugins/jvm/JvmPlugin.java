package com.adang.monitor.agent.plugins.jvm;

import com.adang.monitor.agent.collector.jvm.JvmCollector;
import com.adang.monitor.agent.plugins.AbstractCollectorPlugin;

public class JvmPlugin extends AbstractCollectorPlugin {

    JvmCollector collector  = new JvmCollector();

    //jvm配置文件，配置参数

    @Override
    public void prepare() {

    }
    @Override
    public void afterLoad() {

    }

    @Override
    public String load() {
        collector.start();
        return "jvm plugin";
    }

    @Override
    public void shutdown() {

    }
}
