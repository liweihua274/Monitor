package com.adang.monitor.agent.store.file;

public class IndexFile {

    /**
     * 每个报文长度
     */
    public static final int BUFFER_SIZE = 64;
    /**
     * 文件总长度
     */
    public static final long FILE_SIZE = 1024;

    /**
     * 当前位置
     */
    private Long position;

    /**
     * 当前已存报文数
     */
    private int currentStoreCount;




    public Long getPosition() {
        return position;
    }

    public void setPosition(Long position) {
        this.position = position;
    }
}
