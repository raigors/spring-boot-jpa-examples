package com.github.spring.boot.jpa.many.to.many;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author shishaodong
 */
@EnableJpaAuditing
@SpringBootApplication
public class SpringBootJpaManyToManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaManyToManyApplication.class, args);
    }

}
