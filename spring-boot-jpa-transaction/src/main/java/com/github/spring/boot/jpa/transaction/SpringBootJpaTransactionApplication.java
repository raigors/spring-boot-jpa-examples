package com.github.spring.boot.jpa.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author shishaodong
 */
@EnableAsync
@EnableTransactionManagement
@EnableJpaAuditing
@SpringBootApplication
public class SpringBootJpaTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaTransactionApplication.class, args);
    }

}
