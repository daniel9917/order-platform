package com.ordering.platform.kafka.config.data;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("spring.kafka.producer")
public class KafkaProducerConfigData {
    @Value("${spring.kafka.producer.key-serializer-class}")
    private String keySerializerClass;
    @Value("${spring.kafka.producer.value-serializer-class}")
    private String valueSerializerClass;
    @Value("${spring.kafka.producer.compression-type}")
    private String compressionType;
    @Value("${spring.kafka.producer.acks}")
    private String acks;
    @Value("${spring.kafka.producer.batch-size}")
    private Integer batchSize;
    @Value("${spring.kafka.producer.batch-size-boost-factor}")
    private Integer batchSizeBoostFactor;
    @Value("${spring.kafka.producer.linger-ms}")
    private Integer lingerMs;
    @Value("${spring.kafka.producer.request-timeout-ms}")
    private Integer requestTimeoutMs;
    @Value("${spring.kafka.producer.retry-count}")
    private Integer retryCount;
    @Value("${spring.kafka.producer.buffer-memory-config}")
    private Integer bufferMemoryConfig;
    @Value("${spring.kafka.producer.retries-backoff-ms}")
    private Integer retriesBackoffMs;
    @Value("${spring.kafka.producer.enable-idempotence}")
    private Boolean enableIdempotence;
    @Value("${spring.kafka.producer.connections.max.idle.ms}")
    private Integer connectionsMaxIdleMs;
    @Value("${spring.kafka.producer.retries}")
    private Integer retries;

}