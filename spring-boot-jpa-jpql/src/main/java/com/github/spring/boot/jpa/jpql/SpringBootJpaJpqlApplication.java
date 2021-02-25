package com.github.spring.boot.jpa.jpql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author shishaodong
 */
@EnableJpaAuditing
@SpringBootApplication
public class SpringBootJpaJpqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaJpqlApplication.class, args);
    }

}
