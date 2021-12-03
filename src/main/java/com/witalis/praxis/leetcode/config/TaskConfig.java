package com.witalis.praxis.leetcode.config;

import com.witalis.praxis.leetcode.utils.TaskUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(
    value = "classpath:application.yml",
    ignoreResourceNotFound=true
)
@EnableAutoConfiguration
public class TaskConfig {
    private final Environment environment;

    @Autowired
    public TaskConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public TaskUtils taskUtils(Environment environment) {
        return new TaskUtils(environment);
    }
}
