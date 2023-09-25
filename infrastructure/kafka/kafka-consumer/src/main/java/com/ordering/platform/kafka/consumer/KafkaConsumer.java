package com.ordering.platform.kafka.consumer;

import org.apache.avro.specific.SpecificRecordBase;

import java.util.List;
import java.util.Map;

public interface KafkaConsumer <T extends SpecificRecordBase> {
    void receive (List<T> messages, Map<String,Object> headers);
}
