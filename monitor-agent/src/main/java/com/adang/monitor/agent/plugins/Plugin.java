package com.adang.monitor.agent.plugins;

public interface Plugin {


    /**
     * 插件加载前的处理
     */
    void prepare();

    /**
     * 插件加载后的处理
     */
    void afterLoad();


    String load();

    /**
     *
     */
    void shutdown();


}
