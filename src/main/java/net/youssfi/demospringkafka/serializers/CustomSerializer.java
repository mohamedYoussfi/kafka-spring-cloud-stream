package net.youssfi.demospringkafka.serializers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.youssfi.demospringkafka.entities.PageEvent;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class CustomSerializer implements Serializer<PageEvent> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String topic, PageEvent pageEvent) {
        try {
            return new ObjectMapper().writeValueAsBytes(pageEvent);
        } catch (Exception e) {
            throw new SerializationException(e);
        }
    }

    @Override
    public byte[] serialize(String topic, Headers headers, PageEvent data) {
        return this.serialize(topic,data);
    }

    @Override
    public void close() {
        Serializer.super.close();
    }
}
