package com.adang.monitor.server.processor;

import com.adang.monitor.common.remoting.RequestBody;
import com.alipay.remoting.BizContext;
import com.alipay.remoting.InvokeContext;
import com.alipay.remoting.rpc.protocol.SyncUserProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleServerUserProcessor extends SyncUserProcessor<RequestBody> {

    /** logger */
    private static final Logger logger         = LoggerFactory
            .getLogger(SimpleServerUserProcessor.class);

    private String remoteAddr;


    public SimpleServerUserProcessor(){

    }


    @Override
    public Object handleRequest(BizContext bizCtx, RequestBody requestBody) throws Exception {
        System.out.println("request recived:" + requestBody + ",");
        if (bizCtx.isRequestTimeout()) {
            String errMsg = "Stop process in server biz thread, already timeout!";

            //processTimes(request);
            logger.warn(errMsg);
            throw new Exception(errMsg);
        }
        this.remoteAddr = bizCtx.getRemoteAddress();

        //test biz context get connection
    //    Assert.assertNotNull(bizCtx.getConnection());
     //   Assert.assertTrue(bizCtx.getConnection().isFine());

        Long waittime = (Long) bizCtx.getInvokeContext().get(InvokeContext.BOLT_PROCESS_WAIT_TIME);
    //    Assert.assertNotNull(waittime);
        if (logger.isInfoEnabled()) {
            logger.info("Server User processor process wait time {}", waittime);
        }

     //   latch.countDown();
        logger.warn("Server User processor say, remote address is [" + this.remoteAddr + "].");
        //todo 单开多线程处理

       // Assert.assertEquals(RequestBody.class, request.getClass());
   //     processTimes(request);
     /*   if (!delaySwitch) {
            return RequestBody.DEFAULT_SERVER_RETURN_STR;
        }
        try {
            Thread.sleep(delayMs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } */
        return "server return";

    }

    @Override
    public String interest() {
        return RequestBody.class.getName();
    }
}
