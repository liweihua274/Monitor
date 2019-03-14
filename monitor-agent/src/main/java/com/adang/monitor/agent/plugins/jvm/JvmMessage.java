package com.adang.monitor.agent.plugins.jvm;

import com.adang.monitor.agent.store.Message;

public class JvmMessage extends Message {
    /**
     * 类型  memory，gc，cpu
     */
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
