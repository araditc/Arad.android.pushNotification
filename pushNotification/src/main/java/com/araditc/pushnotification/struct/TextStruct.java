package com.araditc.pushnotification.struct;

import com.araditc.pushnotification.consts.MessageTypes;

public class TextStruct  extends MessageTemplate{
    private int id;
    private String text;

    public TextStruct( ) {
        super(MessageTypes.TEXT);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
