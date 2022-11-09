package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration

public class RestTemplateConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(RestTemplateConfiguration.class);

    @Value("${app.apiKey}")
    private String apiKey;

    @Value("${app.authSchema}")
    private String authSchema;

    @Value("${app.timezone}")
    private String timezone;
    
    
    
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {

        return builder
                .setConnectTimeout(Duration.ofMillis(300000))
                .setReadTimeout(Duration.ofMillis(300000))
//                .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                
                .defaultHeader("X-Time-Zone", timezone)
                .defaultHeader("Auth-Schema", authSchema)
                .defaultHeader("Api-Key", apiKey)
                .additionalInterceptors((request, body, execution) -> {
                    LOG.info("logging intercepted http request to uri: {} with payload {}", request.getURI(), body);
                    LOG.info("logging intercepted http request to uri: {} with headers {}", request.getURI(), request.getHeaders());

                    return execution.execute(request, body);
                })
                .build();
    }

}
