package com.adang.monitor.agent.plugins.classloader;

import com.adang.monitor.agent.plugins.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * 加载插件并实例化成服务
 */
public class ServiceManager {

    private List<Plugin> services= new ArrayList<Plugin>();

    /**
     * 加载插件实例
     */
    public List<Plugin> load(){
        System.out.println("serviceManager load");
        ServiceLoader<Plugin> serviceLoader  = ServiceLoader.load(Plugin.class, MonitorClassLoader.getMonitorClassLoader());
        for (Plugin plugin: serviceLoader){
            System.out.println(plugin.load());
            services.add(plugin);
        }
        return services;
    }


    public void destroy(){
        System.out.println("摧毁实例");
        for(Plugin plugin: services){
           plugin.shutdown();
        }
    }



}
