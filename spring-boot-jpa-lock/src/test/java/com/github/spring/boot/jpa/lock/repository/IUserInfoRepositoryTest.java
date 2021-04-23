package com.github.spring.boot.jpa.lock.repository;

import com.github.spring.boot.jpa.lock.pojo.orm.UserInfoDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;

/**
 * TODO
 * <p>
 * create in 2021/4/23 2:42 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@DataJpaTest()
@ActiveProfiles("dev")
@Rollback(value = false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IUserInfoRepositoryTest {

    @Resource
    private IUserInfoRepository repository;

    @Test
    void findById() {
        long id = 1L;
        UserInfoDO userInfoDO = repository.findById(id);
        Assertions.assertNotNull(userInfoDO);
        log.info("查询到数据:{} - {}", id, userInfoDO);
    }
}