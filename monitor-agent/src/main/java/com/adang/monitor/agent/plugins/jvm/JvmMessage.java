package com.adang.monitor.agent.plugins.jvm;

import com.adang.monitor.agent.store.MessagePersistence;

public class JvmMessage extends MessagePersistence {
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
