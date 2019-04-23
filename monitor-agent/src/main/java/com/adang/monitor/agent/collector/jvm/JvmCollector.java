package com.adang.monitor.agent.collector.jvm;

import com.adang.monitor.agent.collector.disruptor.DisruptorHandler;
import com.adang.monitor.agent.common.Message;
import com.adang.monitor.agent.plugins.jvm.Metric;
import com.adang.monitor.agent.store.file.MonitorFile;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class JvmCollector {

    public void start(){
        System.out.println("开始定时跟踪内存与GC");
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            public void run() {
                Metric.gainMemoryInfo();
                Metric.gainGCInfo();
            }
        }, 0, 5000, TimeUnit.MILLISECONDS);

        File file = new File("D:\\a.txt");
        MonitorFile monitorFile = null;
        try {
            monitorFile = new MonitorFile(file);
            monitorFile.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Message message = assemble();
        DisruptorHandler.getInsatance().publish(message);
    }

    private Message assemble(){
        Message message = new Message();
        message.setTopic("jvm");
        message.setProperties(null);
        return message;
    }
}
