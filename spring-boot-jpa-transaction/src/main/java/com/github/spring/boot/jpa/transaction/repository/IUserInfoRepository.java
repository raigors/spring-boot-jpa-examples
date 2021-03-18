package com.github.spring.boot.jpa.transaction.repository;


import com.github.spring.boot.jpa.transaction.pojo.orm.UserInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;
import java.util.Optional;

/**
 * 用户信息增删改查接口
 * <p>
 * create in 2021/2/23 5:38 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IUserInfoRepository extends JpaRepository<UserInfoDO, Long> {

    /**
     * 根据 ID 更新用户名
     *
     * @param id       id
     * @param username 用户名
     * @return int
     */
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE UserInfoDO AS user SET user.username = :username WHERE user.id = :id")
    int updateUsernameById(long id, String username);

    Optional<UserInfoDO> findUserInfoDOById(long id);

}
