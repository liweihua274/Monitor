package com.adang.monitor.server;


import com.adang.monitor.common.remoting.processor.CONNECTEventProcessor;
import com.adang.monitor.common.remoting.processor.DISCONNECTEventProcessor;
import com.adang.monitor.common.remoting.server.BoltServer;
import com.adang.monitor.server.processor.SimpleServerUserProcessor;
import com.alipay.remoting.ConnectionEventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RpcServerDemo {
    static Logger             logger                    = LoggerFactory
            .getLogger(RpcServerDemo.class);

    BoltServer                server;

    int                       port                      = 8999;

    SimpleServerUserProcessor serverUserProcessor       = new SimpleServerUserProcessor();
    CONNECTEventProcessor serverConnectProcessor    = new CONNECTEventProcessor();
    DISCONNECTEventProcessor serverDisConnectProcessor = new DISCONNECTEventProcessor();

    public RpcServerDemo() {
        // 1. create a Rpc server with port assigned
        server = new BoltServer(port);
        // 2. add processor for connect and close event if you need
        server.addConnectionEventProcessor(ConnectionEventType.CONNECT, serverConnectProcessor);
        server.addConnectionEventProcessor(ConnectionEventType.CLOSE, serverDisConnectProcessor);
        // 3. register user processor for client request
        server.registerUserProcessor(serverUserProcessor);
        // 4. server start
        if (server.start()) {
            System.out.println("server start ok!");
        } else {
            System.out.println("server start failed!");
        }
        // server.getRpcServer().stop();
    }

    public static void main(String[] args) {
        new RpcServerDemo();
    }
}
