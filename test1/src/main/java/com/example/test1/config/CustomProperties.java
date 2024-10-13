package com.example.test1.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("custom")
public record CustomProperties(String buildVersion, String javaVersion) {}
