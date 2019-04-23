package com.adang.monitor.agent.plugins;

import com.adang.monitor.agent.plugins.classloader.ServiceManager;

import java.util.ArrayList;
import java.util.List;

public class PluginManager {

    /**
     * 加载的插件列表
     */
    private List<Plugin> plugins = new ArrayList<Plugin>();



    /**
     * 初始化
     */
    public void init() {
        ServiceManager serviceManager = new ServiceManager();
        plugins=serviceManager.load();
    }



    /**
     * 加载插件
     */
    public void loadPlugin() {

    }

    /**
     * 摧毁
     */
    public void destory() {

    }


}
