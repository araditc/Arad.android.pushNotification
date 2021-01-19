package com.araditc.pushnotification.struct;

import com.araditc.pushnotification.consts.MessageTypes;

import org.json.JSONObject;

public class CustomStruct extends MessageTemplate {
    private JSONObject data;

    public CustomStruct() {
        super(MessageTypes.CUSTOM);
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }
}
