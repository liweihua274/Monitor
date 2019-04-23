package com.adang.monitor.agent.collector;


import com.adang.monitor.agent.common.Message;
import com.adang.monitor.agent.thread.ThreadManager;
import com.lmax.disruptor.EventHandler;

/**
 * Created by LIWEIHUA on 2018-03-28.
 */
public class ConsumerDisruptorHandler implements EventHandler {
    public void onEvent(Object o, long l, boolean b) throws Exception {
        System.out.println(Thread.currentThread().getName() + " Element12: " + o.toString());
        if (o instanceof Message){
            System.out.println(o.toString());
        }else{
            throw new RuntimeException("消费消息类型异常");
        }
    }
}
