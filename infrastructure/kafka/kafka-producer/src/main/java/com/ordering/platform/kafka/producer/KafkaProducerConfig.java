package com.ordering.platform.kafka.producer;

import com.ordering.platform.kafka.config.data.KafkaConfigData;
import com.ordering.platform.kafka.config.data.KafkaProducerConfigData;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig <K extends Serializable, V extends SpecificRecordBase> {

    private final KafkaConfigData kafkaConfigData;

    private final KafkaProducerConfigData kafkaProducerConfigData;

    public KafkaProducerConfig(KafkaConfigData kafkaConfigData, KafkaProducerConfigData kafkaProducerConfigData) {
        this.kafkaConfigData = kafkaConfigData;
        this.kafkaProducerConfigData = kafkaProducerConfigData;
    }

    @Bean
    public Map<String, Object> producerConfig() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfigData.getBootstrapServers());
        props.put(ProducerConfig.RETRIES_CONFIG, kafkaProducerConfigData.getRetryCount());
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, kafkaProducerConfigData.getBufferMemoryConfig());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, kafkaProducerConfigData.getKeySerializerClass());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, kafkaProducerConfigData.getValueSerializerClass());
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, kafkaProducerConfigData.getBatchSize() * kafkaProducerConfigData.getBatchSizeBoostFactor());
        props.put(ProducerConfig.ACKS_CONFIG, kafkaProducerConfigData.getAcks());
        props.put("sasl.mechanism", kafkaConfigData.getSaslJassMechanism());
        props.put("sasl.jaas.config", kafkaConfigData.getSaslJassConfig());
        props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, kafkaProducerConfigData.getCompressionType());
        props.put(ProducerConfig.LINGER_MS_CONFIG, kafkaProducerConfigData.getLingerMs());
        props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, kafkaProducerConfigData.getEnableIdempotence());
        props.put(ProducerConfig.CONNECTIONS_MAX_IDLE_MS_CONFIG, kafkaProducerConfigData.getConnectionsMaxIdleMs());
        props.put(ProducerConfig.RETRIES_CONFIG, kafkaProducerConfigData.getRetries());
        props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, kafkaConfigData.getSecurityProtocol());
        props.put("ssl.endpoint.identification.algorithm", kafkaConfigData.getSslEndpointIdentificationAlgorithm());
        props.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, kafkaProducerConfigData.getRetriesBackoffMs());
        props.put("basic.auth.credentials.source", kafkaConfigData.getBasicAuthCredentialsSource());
        props.put("basic.auth.user.info", kafkaConfigData.getBasicAuthUserInfo());
        props.put("schema.registry.basic.auth.user.info", kafkaConfigData.getBasicAuthUserInfo());
        props.put("schema.registry.url", kafkaConfigData.getSchemaRegistryUrl());

        props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, kafkaProducerConfigData.getRequestTimeoutMs());

        return props;
    }

    @Bean
    public ProducerFactory<K, V> producerFactory () {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<K,V> kafkaTemplate () {
        return new KafkaTemplate<>(producerFactory());
    }
}
