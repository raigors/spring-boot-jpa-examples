package com.github.spring.boot.jpa.index;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author shishaodong
 */
@EnableJpaAuditing
@SpringBootApplication
public class SpringBootJpaIndexApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaIndexApplication.class, args);
    }

}
