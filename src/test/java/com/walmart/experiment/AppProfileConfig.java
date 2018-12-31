package com.walmart.experiment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class AppProfileConfig {

    @Value("${prop.name}")
    private String prop;


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }


    @Configuration
    @Profile("dev")
    @PropertySource("classpath:app.properties")
    public static class DevAppConfig {
    }

    @Configuration
    @Profile("test")
    @PropertySource("classpath:app.properties")
    public static class TestAppConfig {
    }
}
