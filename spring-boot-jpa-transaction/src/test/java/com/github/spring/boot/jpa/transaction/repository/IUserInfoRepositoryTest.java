package com.github.spring.boot.jpa.transaction.repository;

import com.github.javafaker.Faker;
import com.github.spring.boot.jpa.transaction.pojo.orm.UserInfoDO;
import com.github.spring.boot.jpa.transaction.service.UserInfoService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 * <p>
 * create in 2021/3/12 5:09 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@SpringBootTest
class IUserInfoRepositoryTest {

    @Resource
    private IUserInfoRepository repository;

    @Resource
    private UserInfoService service;

    private UserInfoDO user;

    @BeforeEach
    void setUp() {
        user = repository.save(getUserInfo());
    }

    void findUser() {
        UserInfoDO user = service.findUser(1L);
        System.out.println(user);
    }

    @Rollback(false)
    @SneakyThrows(InterruptedException.class)
    @Test
    void updateUsernameById() {
        long id = user.getId();
        service.findUserById(1L);
        service.updateUsernameById(id);
        TimeUnit.SECONDS.sleep(5);
    }

    private UserInfoDO getUserInfo() {
        return UserInfoDO.builder()
                .username(getUsername())
                .email(getEmail())
                .age(getAge())
                .build();
    }

    private static final Faker FAKER = new Faker(Locale.CHINESE);

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