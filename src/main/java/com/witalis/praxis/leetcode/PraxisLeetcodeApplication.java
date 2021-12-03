package com.witalis.praxis.leetcode;

import com.witalis.praxis.leetcode.utils.TaskUtils;

import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Desc: Java Praxis - Leetcode
 * User: Wellaxis
 * Date: 2021/03/30
 */
@Slf4j
@SpringBootApplication
@EqualsAndHashCode(callSuper=false)
@ConfigurationPropertiesScan
public class PraxisLeetcodeApplication {

    public static void main(String... args) {
        new SpringApplicationBuilder()
            .sources(PraxisLeetcodeApplication.class)
            .bannerMode(Banner.Mode.LOG)
            .web(WebApplicationType.NONE)
            .headless(false)
            .run(args);
    }

    @Bean
    public CommandLineRunner invoke(ApplicationContext context) {
        var taskUtils = context.getBean(TaskUtils.class);
        return (args) -> ((TaskUtils) taskUtils).invokeTask();
    }
}
