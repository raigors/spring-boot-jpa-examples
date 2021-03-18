package com.github.spring.boot.jpa.switching.table;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author shishaodong
 */
@EnableJpaAuditing
@SpringBootApplication
public class SpringBootJpaSwitchingTableApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaSwitchingTableApplication.class, args);
    }

}
