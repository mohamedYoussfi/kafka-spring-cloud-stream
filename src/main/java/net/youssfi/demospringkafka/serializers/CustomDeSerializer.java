package net.youssfi.demospringkafka.serializers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.youssfi.demospringkafka.entities.PageEvent;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class CustomDeSerializer implements Deserializer<PageEvent> {
    @Override
    public PageEvent deserialize(String s, byte[] data) {
        try {
            return new ObjectMapper().readValue(new String(data),PageEvent.class);
        } catch (Exception e) {
            throw new SerializationException(e);
        }
    }
}
