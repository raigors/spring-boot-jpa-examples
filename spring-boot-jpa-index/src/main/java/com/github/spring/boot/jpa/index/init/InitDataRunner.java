package com.github.spring.boot.jpa.index.init;

import com.github.javafaker.Faker;
import com.github.spring.boot.jpa.index.pojo.orm.UserInfoDO;
import com.github.spring.boot.jpa.index.repository.IUserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

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

    private static final int NUM = 1000000;

    private static final int BATCH = 100;

    private static final int THREADS = 140;

    private static final ExecutorService exeService = Executors.newFixedThreadPool(THREADS);

    @Resource
    private IUserInfoRepository repository;

    @Override
    public void run(String... args) throws InterruptedException {
        AtomicLong atomicLong = new AtomicLong(repository.count());
        for (int i = 0; i < THREADS; i++) {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(1000));
            exeService.execute(() -> {
                List<UserInfoDO> userList = new ArrayList<>(BATCH);
                while (atomicLong.get() < NUM) {
                    UserInfoDO user = getUserInfo();
                    if (!repository.existsByUsername(user.getUsername())) {
                        userList.add(user);
                    }
                    if (userList.size() >= BATCH) {
                        repository.saveAll(userList);
                        long sum = atomicLong.addAndGet(userList.size());
                        log.info("保存数据:{}", sum);
                        userList = new ArrayList<>();
                    }
                }
            });
        }
        log.info("数据初始化完成!");
    }

    private UserInfoDO getUserInfo() {
        return UserInfoDO.builder()
                .username(getUsername())
                .email(getEmail())
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
