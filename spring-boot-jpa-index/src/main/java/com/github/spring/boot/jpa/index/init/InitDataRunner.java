package com.github.spring.boot.jpa.index.init;

import com.github.javafaker.Faker;
import com.github.spring.boot.jpa.index.pojo.bo.EmailBO;
import com.github.spring.boot.jpa.index.pojo.orm.UserInfoDO;
import com.github.spring.boot.jpa.index.repository.IUserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
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

    private static final Faker FAKER2 = new Faker(Locale.CHINA);

    private static final int NUM = 25;

    @Resource
    private IUserInfoRepository repository;

    @Override
    public void run(String... args) {
        while (repository.count() < NUM){
            UserInfoDO user = getUserInfo();
            if (!repository.existsByUsername(user.getUsername())) {
                repository.save(user);
                log.info("保存数据:{}", user);
            }
        }
        log.info("数据初始化完成!");
    }

    private UserInfoDO getUserInfo() {
        return UserInfoDO.builder()
                .username(getUsername())
                .email(new EmailBO(getEmail()))
                .cellPhone(getCellPhone())
                .age(getAge())
                .birthday(getBirthday())
                .ip(getIp())
                .build();
    }

    private String getUsername() {
        return RandomStringUtils.randomAlphabetic(5, 12);
    }

    private String getEmail() {
        return FAKER.internet().emailAddress();
    }

    private int getAge() {
        return FAKER.number().numberBetween(10, 50);
    }

    private String getCellPhone() {
        return FAKER2.phoneNumber().cellPhone();
    }

    private Date getBirthday() {
        return FAKER.date().birthday(10, 50);
    }

    private String getIp() {
        return FAKER.internet().publicIpV4Address();
    }

}
