package com.github.spring.boot.jpa.id.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/5/31 2:31 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Component
public class BeanNameRunner implements CommandLineRunner {

    @Resource
    private ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        context.getBeansOfType(Object.class).forEach((k, v) -> System.out.println(k));
    }
}
