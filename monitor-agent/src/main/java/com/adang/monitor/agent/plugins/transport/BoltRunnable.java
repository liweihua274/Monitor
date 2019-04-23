package com.adang.monitor.agent.plugins.transport;

import com.adang.monitor.agent.transport.BoltClient;
import com.adang.monitor.common.remoting.RequestBody;

public class BoltRunnable implements Runnable {


    private BoltClient client ;

    public BoltRunnable(BoltClient client){
        this.client = client;
    }

    public void run() {
        /* 收集所有信息 */
        RequestBody body = new RequestBody();
        client.send(body);
    }
}
