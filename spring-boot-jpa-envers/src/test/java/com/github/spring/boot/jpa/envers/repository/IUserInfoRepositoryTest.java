package com.github.spring.boot.jpa.envers.repository;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/4/21 4:45 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@DataJpaTest
@Rollback(value = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IUserInfoRepositoryTest {

    @Resource
    private IUserInfoRepository repository;

    @Test
    void findAll() {
        repository.findAll().forEach(one -> log.info("---------- 查询到数据:{}", one));
    }

    @Test
    void findAllRevisions() {
        repository.findRevisions(1L).forEach(one -> log.info("---------- 查询到数据:{}", one));
    }

    @Test
    void updateOne() {
        repository.findById(1L).ifPresent(userInfoDO -> {
            log.info("Before:{}", userInfoDO);
            userInfoDO.setUsername("test_name");
            userInfoDO.setIp("1.1.1.1");
            log.info("Before:{}", repository.save(userInfoDO));
        });
        repository.findRevisions(1L).forEach(one -> log.info("---------- 查询到数据:{}", one));
    }

    @Test
    void findRevisions() {
        repository.findLastChangeRevision(1L)
                .ifPresent(revision -> System.out.println("---------- findLastChangeRevision:" + revision));
        repository.findRevisions(1L)
                .forEach(one -> System.out.println("---------- 历史版本:" + one));
    }

    @DisplayName("只更新单个字段,并不会有历史字段")
    @Test
    void updateIpById() {
        repository.updateIpById(2L, "2.2.2.2");
    }


}