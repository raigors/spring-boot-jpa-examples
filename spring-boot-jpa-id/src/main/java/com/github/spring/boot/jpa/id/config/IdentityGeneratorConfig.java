package com.github.spring.boot.jpa.id.config;

import com.github.spring.boot.jpa.id.service.IdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/5/31 3:12 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Configuration
public class IdentityGeneratorConfig  implements CommandLineRunner {

    @Resource
    IdService service;

    @Override
    public void run(String... args) throws Exception {
        CustomIDGenerator.setService(service);
    }

}
