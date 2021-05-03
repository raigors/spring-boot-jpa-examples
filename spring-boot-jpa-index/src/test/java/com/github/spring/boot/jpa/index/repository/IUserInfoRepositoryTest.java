package com.github.spring.boot.jpa.index.repository;

import com.github.spring.boot.jpa.index.pojo.orm.UserInfoDO;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

/**
 * TODO
 * <p>
 * create in 2021/4/28 12:15 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@ActiveProfiles("local")
@Rollback(value = false)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class IUserInfoRepositoryTest {

    @Resource
    private IUserInfoRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Rollback(value = false)
    @Test
    void saveTest() {
        String newUsername = "test_" + RandomStringUtils.randomAlphabetic(5);
        Optional<UserInfoDO> optional = repository.findById(1L);
        optional.ifPresent(System.out::println);
        optional.ifPresent(userInfo -> userInfo.setUsername(newUsername));
        optional.ifPresent(userInfo -> userInfo.increase(10));
        entityManager.flush();
        entityManager.clear();
        Optional<UserInfoDO> optional1 = repository.findById(1L);
        optional1.ifPresent(userInfoDO -> Assertions.assertEquals(newUsername, userInfoDO.getUsername()));
    }

}