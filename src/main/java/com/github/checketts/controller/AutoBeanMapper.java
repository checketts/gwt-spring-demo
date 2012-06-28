package com.github.checketts.controller;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.module.SimpleModule;

public class AutoBeanMapper extends ObjectMapper{
    
    public AutoBeanMapper() {
        SimpleModule module = new SimpleModule("Ekotrope", new Version(1, 0, 0, null));
        module.addSerializer(Date.class, new DateSerializer());
        module.addDeserializer(Date.class, new DateDeserializer());
        module.addSerializer(Long.class, new LongSerializer());
        module.addDeserializer(Long.class, new LongDeserializer());
        registerModule(module);
    }
 
    private static class DateSerializer extends JsonSerializer<Date>
    {
        @Override
        public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
              throws IOException, JsonProcessingException
        {
            String str = "" + value.getTime();
            jgen.writeString(str);
        }
    }
   
    private static class DateDeserializer extends JsonDeserializer<Date>
    {
        @Override
        public Date deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException
        {
            String str = jp.getText();
            Long value = Long.parseLong(str);
            Date date = new Date(value);
            return date;
        }
    }
   
    public static class LongSerializer extends JsonSerializer<Long>
    {
        @Override
        public void serialize(Long value, JsonGenerator jgen, SerializerProvider provider)
              throws IOException, JsonProcessingException
        {
            String str = "" + value.toString();
            jgen.writeString(str);
        }
    }
   
    public static class LongDeserializer extends JsonDeserializer<Long>
    {
        @Override
        public Long deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException
        {
            String str = jp.getText();
            Long value = Long.parseLong(str);
            return value;
        }
    }

}
