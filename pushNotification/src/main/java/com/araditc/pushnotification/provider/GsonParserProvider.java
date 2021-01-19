package com.araditc.pushnotification.provider;

import com.araditc.pushnotification.struct.MessageTemplate;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public final class GsonParserProvider {
    private GsonParserProvider() {
    }

    public static Gson provideMessageTemplate() {
        GsonBuilder gsonBilder = new GsonBuilder();
        gsonBilder.registerTypeAdapter(MessageTemplate.class, new MessageTemplateParserAdapter());
        return gsonBilder.create();
    }
}
