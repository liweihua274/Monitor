/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.adang.monitor.agent.transport;

import com.adang.monitor.common.remoting.RequestBody;
import com.adang.monitor.common.remoting.processor.CONNECTEventProcessor;
import com.adang.monitor.common.remoting.processor.DISCONNECTEventProcessor;
import com.adang.monitor.common.remoting.processor.SimpleClientUserProcessor;
import com.alipay.remoting.ConnectionEventType;
import com.alipay.remoting.exception.RemotingException;
import com.alipay.remoting.rpc.RpcClient;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author tsui
 * @version $Id: ClientConnectionTest.java, v 0.1 2017-09-13 14:20 tsui Exp $
 */
public  class BoltClient {
    static Logger             logger                    = LoggerFactory
            .getLogger(BoltClient.class);

    private RpcClient client;

    private final String  addr                      = "127.0.0.1:8999";

    SimpleClientUserProcessor clientUserProcessor       = new SimpleClientUserProcessor();
    private final CONNECTEventProcessor clientConnectProcessor    = new CONNECTEventProcessor();
    private final DISCONNECTEventProcessor clientDisConnectProcessor = new DISCONNECTEventProcessor();

    public BoltClient() {
        // 1. create a rpc client
        client = new RpcClient();
        // 2. add processor for connect and close event if you need
        client.addConnectionEventProcessor(ConnectionEventType.CONNECT, clientConnectProcessor);
        client.addConnectionEventProcessor(ConnectionEventType.CLOSE, clientDisConnectProcessor);
        // 3. do init
        client.init();
    }

    public String send(RequestBody requestBody){
        String res = null;
        try {
            res = (String) client.invokeSync(addr, requestBody, 3000);
        } catch (RemotingException e) {
            String errMsg = "RemotingException caught in oneway!";
            logger.error(errMsg, e);
            Assert.fail(errMsg);
        } catch (InterruptedException e) {
            logger.error("interrupted!");
        }
        return res;

    }

    public static void main(String[] args) {
        BoltClient bolt = new BoltClient();
        RequestBody req = new RequestBody(2, "hello world sync");
        try {
            String res = (String) bolt.client.invokeSync(bolt.addr, req, 3000);
            System.out.println("invoke sync result = [" + res + "]");
        } catch (RemotingException e) {
            String errMsg = "RemotingException caught in oneway!";
            logger.error(errMsg, e);
            Assert.fail(errMsg);
        } catch (InterruptedException e) {
            logger.error("interrupted!");
        }
        bolt.client.shutdown();
    }

}