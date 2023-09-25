package com.ordering.platform.kafka.config.data;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("spring.kafka.consumer")
public class KafkaConsumerConfigData {
    @Value("${spring.kafka.consumer.key-deserializer}")
    private String keyDeserializer;
    @Value("${spring.kafka.consumer.value-deserializer}")
    private String valueDeserializer;
    @Value("${spring.kafka.consumer.auto-offset-reset}")
    private String autoOffsetReset;
    @Value("${spring.kafka.consumer.specific-avro-reader-key}")
    private String specificAvroReaderKey;
    @Value("${spring.kafka.consumer.specific-avro-reader}")
    private String specificAvroReader;
    @Value("${spring.kafka.consumer.batch-listener}")
    private Boolean batchListener;
    @Value("${spring.kafka.consumer.auto-startup}")
    private Boolean autoStartup;
    @Value("${spring.kafka.consumer.concurrency-level}")
    private Integer concurrencyLevel;
    @Value("${spring.kafka.consumer.retry-backoff-ms}")
    private Integer retryBackoffMs;
    @Value("${spring.kafka.consumer.session-timeout-ms}")
    private Integer sessionTimeoutMs;
    @Value("${spring.kafka.consumer.heartbeat-interval-ms}")
    private Integer heartbeatIntervalMs;
    @Value("${spring.kafka.consumer.max-poll-interval-ms}")
    private Integer maxPollIntervalMs;
    @Value("${spring.kafka.consumer.max-poll-records}")
    private Long pollTimeoutMs;
    @Value("${spring.kafka.consumer.max-partition-fetch-bytes-default}")
    private Integer maxPollRecords;
    @Value("${spring.kafka.consumer.max-partition-fetch-bytes-boost-factor}")
    private Integer maxPartitionFetchBytesDefault;
    @Value("${spring.kafka.consumer.poll-timeout-ms}")
    private Integer maxPartitionFetchBytesBoostFactor;

}

