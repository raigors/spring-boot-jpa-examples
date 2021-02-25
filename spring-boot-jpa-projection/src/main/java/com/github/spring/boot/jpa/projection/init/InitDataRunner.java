package com.github.spring.boot.jpa.projection.init;

import com.github.javafaker.Faker;
import com.github.spring.boot.jpa.projection.pojo.orm.SimpleUserInfoDO;
import com.github.spring.boot.jpa.projection.repository.ISimpleUserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * 初始化数据
 * <p>
 * create in 2021/2/23 7:48 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@Component
public class InitDataRunner implements CommandLineRunner {

    private static final Faker FAKER = new Faker(Locale.CHINESE);

    private static final int NUM = 100;

    @Resource
    private ISimpleUserInfoRepository repository;


    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            for (int i = 0; i < NUM; i++) {
                SimpleUserInfoDO user = getUserInfo();
                repository.save(user);
                log.info("save : {}", user.toString());
            }
        }
    }

    private SimpleUserInfoDO getUserInfo() {
        return SimpleUserInfoDO.builder()
                .username(getUsername())
                .email(getEmail())
                .age(getAge())
                .build();
    }

    private String getUsername() {
        return FAKER.name().username();
    }

    private String getEmail() {
        return FAKER.internet().emailAddress();
    }

    private int getAge() {
        return FAKER.number().numberBetween(10, 50);
    }

}
