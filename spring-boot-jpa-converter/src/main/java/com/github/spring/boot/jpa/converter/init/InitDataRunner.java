package com.github.spring.boot.jpa.converter.init;

import com.github.javafaker.Faker;
import com.github.spring.boot.jpa.converter.pojo.orm.UserInfoDO;
import com.github.spring.boot.jpa.converter.repository.IUserInfoRepository;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
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

    private static final int BOOK = 4;

    @Resource
    private IUserInfoRepository repository;

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            for (int i = 0; i < NUM; i++) {
                UserInfoDO user = getUserInfo();
                repository.save(user);
                log.info("save : {}", user);
            }
        }
    }

    private UserInfoDO getUserInfo() {
        return UserInfoDO.builder()
                .username(getUsername())
                .password(getPassword())
                .email(getEmail())
                .age(getAge())
                .ip(getIp())
                .books(getBooks())
                .build();
    }

    private String getPassword() {
        return FAKER.internet().password(10, 16);
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

    private List<String> getBooks() {
        List<String> list = Lists.newArrayList();
        for (int i = 0; i < BOOK; i++) {
            list.add(FAKER.book().title());
        }
        return list;
    }

    private String getIp() {
        return FAKER.internet().publicIpV4Address();
    }
}
