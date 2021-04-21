package com.github.spring.boot.jpa.transaction.service;

import com.github.spring.boot.jpa.transaction.pojo.orm.UserInfoDO;
import com.github.spring.boot.jpa.transaction.repository.IUserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

/**
 * 同一个session内部，一级缓存生效，同一个id的对象只有一个。不同session，一级缓存无效。
 *
 * @author shishaodong
 * @version 0.0.1
 * \@PersistenceContext private EntityManager entityManager;
 *
 * <p>
 * create in 2021/3/12 5:13 下午
 */

@Slf4j
@Component
public class UserInfoService {

    private static final String USERNAME = "AFTER_USERNAME";

    @Resource
    private IUserInfoRepository repository;

    @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
    public UserInfoDO findUser(long id) {
        return repository.findById(id).orElse(null);
    }

    @Async
    @Transactional(readOnly = true, rollbackFor = {Exception.class}, isolation = Isolation.READ_UNCOMMITTED, propagation = REQUIRED)
    public void findUserById(long id) throws InterruptedException {
        Optional<UserInfoDO> optional1 = repository.findUserInfoDOById(id);
        UserInfoDO user1 = optional1.orElseGet(UserInfoDO::new);
        log.info("FindUserById - 1 - {}", user1);
        TimeUnit.SECONDS.sleep(3);
        Optional<UserInfoDO> optional2 = repository.findUserInfoDOById(id);
        UserInfoDO user2 = optional2.orElseGet(UserInfoDO::new);
        log.info("FindUserById - 2 - {}", user2);
    }

    @Async
    @Transactional(rollbackFor = {Exception.class}, isolation = Isolation.READ_UNCOMMITTED, propagation = REQUIRES_NEW)
    public void updateUsernameById(long id) {
        Optional<UserInfoDO> optional1 = repository.findUserInfoDOById(id);
        log.info("before update:{}", optional1.orElseGet(UserInfoDO::new).getUsername());
        int num = repository.updateUsernameById(id, USERNAME);
        log.info("after update:{}", num);
        Optional<UserInfoDO> optional2 = repository.findUserInfoDOById(id);
        log.info("optional2 -------- {}", optional2.orElseGet(UserInfoDO::new).getUsername());
    }


}
