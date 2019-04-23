package com.adang.monitor.agent;

import com.adang.monitor.agent.collector.disruptor.DisruptorHandler;
import com.adang.monitor.agent.plugins.PluginManager;
import com.adang.monitor.agent.transport.BoltClient;

import java.lang.instrument.Instrumentation;

public class AgentMain {

    PluginManager pluginManager;

    public static AgentMain main = new AgentMain();

    public AgentMain(){
        pluginManager = new PluginManager();
    }



    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("this is an agent.");
        main.initAgent();
    }

    private void initAgent(){
        pluginManager.init();
        //初始化disrupter
        DisruptorHandler.getInsatance().init();

    }






}
