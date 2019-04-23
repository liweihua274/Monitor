package com.adang.monitor.agent.store;

/**
 * 消息存储结构
 */
public abstract class MessagePersistence {

    /**
     * 主键 id
     */
    private String key;

    /**
     * 发生时间
     */
    private Long occurTime;

    /**
     * 内容
     */
    private String content;
    /**
     * 状态
     */
    private Byte status;

    /**
     * 消息类型 0,：jvm  1：log  2：trace
     */
    private Byte messageType;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getOccurTime() {
        return occurTime;
    }

    public void setOccurTime(Long occurTime) {
        this.occurTime = occurTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getMessageType() {
        return messageType;
    }

    public void setMessageType(Byte messageType) {
        this.messageType = messageType;
    }
}
