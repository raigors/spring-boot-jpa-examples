package com.github.spring.boot.jpa.transaction;

import com.github.javafaker.Faker;
import com.github.spring.boot.jpa.transaction.pojo.orm.UserInfoDO;
import lombok.extern.slf4j.Slf4j;

import java.util.Locale;

/**
 * TODO
 * <p>
 * create in 2021/3/19 11:09 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
public class UserInfoUtil {

    private UserInfoUtil() {
    }

    public static UserInfoDO getUserInfo() {
        return UserInfoDO.builder()
                .username(getUsername())
                .email(getEmail())
                .age(getAge())
                .build();
    }

    private static final Faker FAKER = new Faker(Locale.CHINESE);

    private static String getUsername() {
        return FAKER.name().username();
    }

    private static String getEmail() {
        return FAKER.internet().emailAddress();
    }

    private static int getAge() {
        return FAKER.number().numberBetween(10, 50);
    }

}
