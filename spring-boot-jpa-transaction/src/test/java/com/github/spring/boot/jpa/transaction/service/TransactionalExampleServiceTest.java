package com.github.spring.boot.jpa.transaction.service;

import com.github.spring.boot.jpa.transaction.UserInfoUtil;
import com.github.spring.boot.jpa.transaction.pojo.orm.UserInfoDO;
import com.github.spring.boot.jpa.transaction.repository.IUserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * TODO
 * <p>
 * create in 2021/3/19 11:07 上午
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Slf4j
@SpringBootTest
@Rollback
@DirtiesContext
class TransactionalExampleServiceTest {

    @Resource
    private IUserInfoRepository repository;

    @Resource
    private TransactionalExampleService service;

    private UserInfoDO saved;

    private static final String UPDATE_USERNAME = "test_timeout";

    @BeforeEach
    void beforeEach() {
        UserInfoDO unsaved = UserInfoUtil.getUserInfo();
        saved = repository.save(unsaved);
    }

    @AfterEach
    void afterEach() {
        repository.delete(saved);
    }

    @Test
    @DisplayName("抛出异常事务回滚-Y")
    void transactionWillRollback() {
        Assertions.assertThrows(Exception.class, () -> service.transactionWillRollback(saved.getId(), UPDATE_USERNAME));
        Optional<UserInfoDO> optional = repository.findById(saved.getId());
        String username = optional.orElse(new UserInfoDO()).getUsername();
        String message = "Before - " + saved.getUsername() + ", After " + username;
        log.info(message);
        Assertions.assertEquals(saved.getUsername(), username, message);
    }

    @Test
    @DisplayName("抛出异常事务回滚-N")
    void transactionWillNotRollback1() {
        Assertions.assertThrows(Exception.class, () -> service.transactionWillNotRollback1(saved.getId(), UPDATE_USERNAME));
        Optional<UserInfoDO> optional = repository.findById(saved.getId());
        String username = optional.orElse(new UserInfoDO()).getUsername();
        String message = "Before - " + saved.getUsername() + ", After " + username;
        log.info(message);
        Assertions.assertNotEquals(saved.getUsername(), username, message);
    }

    @Test
    @DisplayName("抛出异常事务回滚-N")
    void transactionWillNotRollback2() {
        Assertions.assertThrows(Exception.class, () -> service.transactionWillNotRollback2(saved.getId(), UPDATE_USERNAME));
        Optional<UserInfoDO> optional = repository.findById(saved.getId());
        String username = optional.orElse(new UserInfoDO()).getUsername();
        String message = "Before - " + saved.getUsername() + ", After " + username;
        log.info(message);
        Assertions.assertNotEquals(saved.getUsername(), username, message);
    }


    @Test
    @DisplayName("抛出异常事务回滚-N")
    void transactionWillNotRollback3() {
        Assertions.assertThrows(Exception.class, () -> service.transactionWillNotRollback3(saved.getId(), UPDATE_USERNAME));
        Optional<UserInfoDO> optional = repository.findById(saved.getId());
        String username = optional.orElse(new UserInfoDO()).getUsername();
        String message = "Before - " + saved.getUsername() + ", After " + username;
        log.info(message);
        Assertions.assertEquals(UPDATE_USERNAME, username, message);
    }

}