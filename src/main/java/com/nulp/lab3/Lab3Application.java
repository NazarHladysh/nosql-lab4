package com.nulp.lab3;

import com.nulp.lab3.repository.TripRepository;
import com.nulp.lab3.service.Strategy;
import com.nulp.lab3.service.impl.CassandraWriter;
import com.nulp.lab3.service.impl.ConsoleWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Lab3Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab3Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    @ConditionalOnProperty(prefix = "writer", name = "cassandra", havingValue = "true")
    public Strategy cassandraWriter(TripRepository tripRepository) {
        return new CassandraWriter(tripRepository);
    }

    @Bean
    @ConditionalOnMissingBean
//    @ConditionalOnProperty(prefix = "writer", name = "console", havingValue = "true")
    public Strategy consoleWriter() {
        return new ConsoleWriter();
    }

}
