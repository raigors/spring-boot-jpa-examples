package com.github.spring.boot.jpa.one.to.many;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author shishaodong
 */
@EnableJpaAuditing
@SpringBootApplication
public class SpringBootJpaOneToManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaOneToManyApplication.class, args);
    }

}
