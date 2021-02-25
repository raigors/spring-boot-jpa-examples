package com.github.spring.boot.jpa.converter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author shishaodong
 */
@EnableJpaAuditing
@SpringBootApplication
public class SpringBootJpaConverterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaConverterApplication.class, args);
    }

}
