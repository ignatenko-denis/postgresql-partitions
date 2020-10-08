package com.sample.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Configuration
@Component
@Slf4j
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private String label;

    @PostConstruct
    private void log() {
        StringBuilder builder = new StringBuilder(300);

        builder.append("Application Configuration:").append("\n")
                .append("\tlabel: ").append(label).append("\n");

        log.info(builder.toString());
    }
}
