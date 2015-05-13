package de.igorlueckel.vending.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Igor on 13.05.2015.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableAsync
@EnableScheduling
public class ApplicationStart extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class, args);
    }
}
