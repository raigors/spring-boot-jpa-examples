package com.github.spring.boot.jpa.transaction.service;

import com.github.spring.boot.jpa.transaction.pojo.orm.UserInfoDO;
import com.github.spring.boot.jpa.transaction.repository.IUserInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 事务回滚和不回滚的几种情况
 * <p>
 * create in 2021/3/19 1:29 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Slf4j
@Component
public class TransactionalExampleService {

    public static final String MESSAGE = "发生了异常";
    @Resource
    private IUserInfoRepository repository;

    /**
     * 默认, 所有所有的非检查异常都会回滚
     *
     * @param id       记录的 ID
     * @param username 修改的数据
     */
    @Transactional(rollbackFor = {Exception.class})
    public void transactionWillRollback(long id, String username) throws IOException {
        method(id, username);
    }

    /**
     * 这种情况不会回滚
     * {@link IOException} 是受检查异常,默认不回滚,除非在 {@link Transactional#rollbackFor()} 中指定
     *
     * @param id       记录的 ID
     * @param username 修改的数据
     */
    @Transactional(rollbackFor = {RuntimeException.class})
    public void transactionWillNotRollback1(long id, String username) throws IOException {
        method(id, username);
    }

    /**
     * 这种情况不会回滚
     * {@link IOException} 是受检查异常,默认不回滚,除非在 {@link Transactional#rollbackFor()} 中指定
     *
     * @param id       记录的 ID
     * @param username 修改的数据
     */
    @Transactional(rollbackFor = {Exception.class}, noRollbackFor = {IOException.class})
    public void transactionWillNotRollback2(long id, String username) throws IOException {
        method(id, username);
    }

    /**
     * 这种情况不会回滚
     * {@link Transactional#rollbackFor()} 中指定了非受检异常不回滚
     *
     * @param id       记录的 ID
     * @param username 修改的数据
     */
    @Transactional(rollbackFor = {Exception.class}, noRollbackFor = {ArithmeticException.class})
    public void transactionWillNotRollback3(long id, String username) {
        log.info("修改之前的数据: {}", repository.findById(id).orElse(new UserInfoDO()).toString());
        int num = repository.updateUsernameById(id, username);
        log.info("修改的 ID: {}, 修改的数据: {}, 修改结果: {}", id, username, num);
        int a = 11 / 0;
    }

    /**
     * 这种情况不会回滚
     * {@link Transactional#rollbackFor()} 中指定了非受检异常不回滚
     *
     * @param id       记录的 ID
     * @param username 修改的数据
     */
    @Transactional(rollbackFor = {ArithmeticException.class})
    public void transactionWillNotRollback4(long id, String username) {
        log.info("修改之前的数据: {}", repository.findById(id).orElse(new UserInfoDO()).toString());
        int num = repository.updateUsernameById(id, username);
        log.info("修改的 ID: {}, 修改的数据: {}, 修改结果: {}", id, username, num);
        int a = 11 / 0;
    }

    private void method(long id, String username) throws IOException {
        log.info("修改之前的数据: {}", repository.findById(id).orElse(new UserInfoDO()).toString());
        int num = repository.updateUsernameById(id, username);
        log.info("修改的 ID: {}, 修改的数据: {}, 修改结果: {}", id, username, num);
        throw new IOException(MESSAGE);
    }

}
