package com.adang.monitor.agent.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by LIWEIHUA on 2018-03-27.
 */
public class ThreadManager {

    private static final ThreadManager threadManager = new ThreadManager();

    public static ThreadManager getInstance(){
        return threadManager;
    }

    private final ExecutorService consumerExecutor;

    private final ExecutorService producerExecutor;

    private ThreadManager(){
        consumerExecutor = Executors.newFixedThreadPool(8,
                new ThreadMessageFactory("consumerMessage"));

        producerExecutor = Executors.newFixedThreadPool(8,
                new ThreadMessageFactory("producerMessage"));
    }


    public ExecutorService getConsumerExecutor() {
        return consumerExecutor;
    }

    public ExecutorService getProducerExecutor() {
        return producerExecutor;
    }
}
