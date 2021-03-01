package com.github.spring.boot.jpa.projection.init;

import com.github.javafaker.Faker;
import com.github.spring.boot.jpa.projection.pojo.orm.SystemMenuDO;
import com.github.spring.boot.jpa.projection.repository.ISystemMenuRepository;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Locale;

/**
 * TODO
 * <p>
 * create in 2021/2/26 9:35 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Component
public class InitSystemMenuDataRunner implements CommandLineRunner {

    private static final Faker FAKER = new Faker(Locale.CHINESE);

    private static final int LEVELS = 6;

    private static final int ITEMS = 6;

    @Resource
    private ISystemMenuRepository repository;

    @Override
    public void run(String... args) {
        if (repository.count() == 0) {
            for (int i = 0; i < LEVELS; i++) {
//                extracted1(i);
                extracted2(i);
            }
        }
    }

    private void extracted1(int i) {
        List<SystemMenuDO> list = Lists.newArrayList();
        for (int i1 = 0; i1 < ITEMS; i1++) {
            list.add(repository.save(getSystemMenu(i1 + 1)));
        }
        SystemMenuDO menu = getSystemMenu(i + 1);
        menu.setChildMenus(list);
        repository.save(menu);
    }

    private void extracted2(int i) {
        SystemMenuDO menu = getSystemMenu(i + 1, null);
        SystemMenuDO saved = repository.save(menu);
        for (int i1 = 0; i1 < ITEMS; i1++) {
            repository.save(getSystemMenu(i1 + 1, saved));
        }
    }

    private SystemMenuDO getSystemMenu(int priority, SystemMenuDO menu) {
        return SystemMenuDO.builder()
                .name(name())
                .code(code())
                .priority(priority)
                .parentMenu(menu)
                .build();
    }

    private SystemMenuDO getSystemMenu(int priority) {
        return SystemMenuDO.builder()
                .name(name())
                .code(code())
                .priority(priority)
                .build();
    }

    private String name() {
        return FAKER.name().firstName();
    }

    private String code() {
        return RandomStringUtils.randomAlphabetic(10);
    }

}
