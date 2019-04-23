package com.adang.monitor.agent.common;

import java.io.Serializable;
import java.util.Map;

public class Message implements Serializable {
    private String topic;

    //消息类型， jvm消息，tracer消息，log消息
    private byte type;

    private Map<String, String> properties;

    private byte[] body;


    @Override
    public String toString() {
        return "Message [topic=" + topic +  ", properties=" + properties + ", body="
                + (body != null ? body.length : 0) + "]";
    }


    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public void setBody(byte[] body) {
        this.body = body;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
