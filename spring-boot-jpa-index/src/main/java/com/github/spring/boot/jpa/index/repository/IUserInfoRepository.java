package com.github.spring.boot.jpa.index.repository;

import com.github.spring.boot.jpa.index.pojo.orm.UserInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户信息增删改查接口
 * <p>
 * create in 2021/2/23 5:38 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IUserInfoRepository extends JpaRepository<UserInfoDO, Long> {

    boolean existsByUsername(String username);

    @Modifying
    @Transactional(rollbackFor = Exception.class)
    @Query("UPDATE UserInfoDO AS user SET user.ip = :ip WHERE user.id = :id")
    int updateIpById(long id, String ip);


}
