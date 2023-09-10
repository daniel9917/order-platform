package com.ordering.platform.kafka.config.data;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
//@ConfigurationProperties(prefix = "kafka-config")
public class KafkaConfigData {
    @Value("${spring.kafka.properties.basic.auth.credentials.source}")
    private String basicAuthCredentialsSource;
    @Value("${spring.kafka.properties.basic.auth.user.info}")
    private String basicAuthUserInfo;
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;
    @Value("${spring.kafka.properties.basic.auth.credentials.source}")
    private String schemaRegistryUrlKey;
    @Value("${spring.kafka.properties.schema.registry.url}")
    private String schemaRegistryUrl;
    @Value("${spring.kafka.properties.sasl.jaas.config}")
    private String saslJassConfig;
    @Value("${spring.kafka.properties.sasl.mechanism}")
    private String saslJassMechanism;
    @Value("${spring.kafka.properties.security.protocol}")
    private String securityProtocol;
    @Value("${spring.kafka.properties.ssl.endpoint.identification.algorithm}")
    private String sslEndpointIdentificationAlgorithm;
//    private Integer numOfPartitions;
//    private Short replicationFactor;
}
