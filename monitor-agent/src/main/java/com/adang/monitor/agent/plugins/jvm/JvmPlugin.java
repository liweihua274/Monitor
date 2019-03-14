package com.adang.monitor.agent.plugins.jvm;

import com.adang.monitor.agent.plugins.Plugin;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class JvmPlugin implements Plugin {
    @Override
    public void prepare() {

    }

    @Override
    public void afterLoad() {

    }

    @Override
    public String excute() {
        System.out.println("开始定时跟踪内存与GC");
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            public void run() {
                Metric.gainMemoryInfo();
                Metric.gainGCInfo();
            }
        }, 0, 5000, TimeUnit.MILLISECONDS);
        return "jvm plugin";
    }

    @Override
    public void shutdown() {

    }
}
