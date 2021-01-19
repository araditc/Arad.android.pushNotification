package com.araditc.pushnotification.provider;

import com.araditc.pushnotification.struct.MessageTemplate;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class MessageTemplateParserAdapter implements JsonSerializer<MessageTemplate>, JsonDeserializer<MessageTemplate> {

    @Override
    public MessageTemplate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        JsonElement element = jsonObject.get("properties");

        return context.deserialize(element, typeOfT);
    }

    @Override
    public JsonElement serialize(MessageTemplate src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.add("type", new JsonPrimitive(src.getClass().getSimpleName()));
        result.add("properties", context.serialize(src, src.getClass()));

        return result;
    }
}
