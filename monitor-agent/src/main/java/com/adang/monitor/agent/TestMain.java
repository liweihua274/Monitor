package com.adang.monitor.agent;

import com.adang.monitor.agent.classloader.MonitorClassLoader;
import com.adang.monitor.agent.classloader.ServiceManager;
import com.adang.monitor.agent.plugins.jvm.Metric;

import java.lang.instrument.Instrumentation;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestMain {
    public static void main(String[] args){
        System.out.println("aaa");
        TestMain main = new TestMain();
        main.initAgent();
    }



    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("this is an agent.");
        System.out.println("args:" + agentArgs + "\n");
        TestMain main = new TestMain();
        main.initAgent();
    }

    private void initAgent(){
        //检查端口，包括发送端口/接收端口

        //检查插件配置，并加载插件
        installPlugins();
        //检查
    }

    private void installPlugins(){
        MonitorClassLoader classLoader = MonitorClassLoader.getMonitorClassLoader();
       /* try {
            classLoader.loadClass("com.adang.monitor.agent.plugins.jvm.JvmPlugin");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        ServiceManager serviceManager = new ServiceManager();
        serviceManager.load();
        //检查插件环境
        //加载插件
    }




}
