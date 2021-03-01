package com.github.spring.boot.jpa.json;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author shishaodong
 */
@EnableJpaAuditing
@SpringBootApplication
@EnableTransactionManagement
public class SpringBootJpaJsonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaJsonApplication.class, args);
    }

}
