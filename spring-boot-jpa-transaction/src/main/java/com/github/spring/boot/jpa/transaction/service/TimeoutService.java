package com.github.spring.boot.jpa.transaction.service;

import com.github.spring.boot.jpa.transaction.pojo.orm.UserInfoDO;
import com.github.spring.boot.jpa.transaction.repository.IUserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.security.auth.login.AccountLockedException;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 * <p>
 * create in 2021/3/19 1:29 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Component
public class TimeoutService {

    @Resource
    private IUserInfoRepository repository;

    /**
     * @param id       记录的 ID
     * @param username 修改的数据
     */
    @Transactional(rollbackFor = {Exception.class}, timeout = 2, propagation = Propagation.REQUIRED)
    public void timeoutWillRollback(long id, String username) throws InterruptedException {
        log.info("修改之前的数据: {}", repository.findById(id).orElse(new UserInfoDO()));
        int num = repository.updateUsernameById(id, username);
        log.info("修改的 ID: {}, 修改的数据: {}, 修改结果: {}", id, username, num);
        TimeUnit.SECONDS.sleep(3);
        repository.updateAge(id);
    }

    /**
     * @param id       记录的 ID
     * @param username 修改的数据
     */
    @Transactional(rollbackFor = {Exception.class}, timeout = 2, propagation = Propagation.REQUIRED)
    public void timeoutWillRollback2(long id, String username) throws InterruptedException {
        log.info("修改之前的数据: {}", repository.findById(id).orElse(new UserInfoDO()));
        int num = repository.updateUsernameById(id, username);
        log.info("修改的 ID: {}, 修改的数据: {}, 修改结果: {}", id, username, num);
        TimeUnit.SECONDS.sleep(3);
        repository.updateAge(id);
    }

    /**
     * @param id       记录的 ID
     * @param username 修改的数据
     */
    @Transactional(rollbackFor = {AccountLockedException.class}, timeout = 2)
    public void timeoutWillNotRollback(long id, String username) throws InterruptedException {
        log.info("修改之前的数据: {}", repository.findById(id).orElse(new UserInfoDO()));
        int num = repository.updateUsernameById(id, username);
        log.info("修改的 ID: {}, 修改的数据: {}, 修改结果: {}", id, username, num);
        repository.updateAge(id);
        TimeUnit.SECONDS.sleep(3);
    }
}
