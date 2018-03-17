package com.tona.backendninja;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@SpringBootApplication
@EnableScheduling
public class BackendninjaApplication {
    private static final Log LOG = LogFactory.getLog(BackendninjaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BackendninjaApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {
            LOG.info("-- Beans provided for Spring boot:");
            String[] beans = context.getBeanDefinitionNames();
            Arrays.sort(beans);
            for (String bean : beans)
                LOG.info(bean);
            LOG.info("-- FIN --");
        };
    }
}
