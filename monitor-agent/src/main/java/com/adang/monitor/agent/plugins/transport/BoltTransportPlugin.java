package com.adang.monitor.agent.plugins.transport;

import com.adang.monitor.agent.plugins.AbstractSinkPlugin;
import com.adang.monitor.agent.transport.BoltClient;

public class BoltTransportPlugin extends AbstractSinkPlugin {

    private BoltRunnable bolt = null;

    private BoltClient client = null;

    @Override
    public void prepare() {

    }
    @Override
    public void afterLoad() {

    }
    @Override
    public String load() {
        //考虑用事件驱动机制，采集一条信息直接发送，不能用定时的job去处理，采用disrupter方式处理
        client = new BoltClient();
        System.out.println("开始启动bolt传输数据");

        //Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new BoltRunnable(client), 0, 5000, TimeUnit.MILLISECONDS);
        return "boltPlugin";
    }

    @Override
    public void shutdown() {

    }
}
