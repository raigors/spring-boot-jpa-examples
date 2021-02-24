package com.github.spring.boot.jpa.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author shishaodong
 */
@EnableJpaAuditing
@EnableTransactionManagement
@SpringBootApplication
public class SpringBootJpaEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaEventApplication.class, args);
    }

}
