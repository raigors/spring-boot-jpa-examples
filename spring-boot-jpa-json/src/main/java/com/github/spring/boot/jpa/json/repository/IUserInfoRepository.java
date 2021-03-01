package com.github.spring.boot.jpa.json.repository;

import com.github.spring.boot.jpa.json.pojo.orm.UserInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * 用户信息增删改查接口
 * <p>
 * create in 2021/2/23 5:38 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IUserInfoRepository extends JpaRepository<UserInfoDO, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE UserInfoDO AS user SET user.address = FUNCTION('JSON_REPLACE', user.address,'$.name', :address) WHERE user.username = :username")
    int replace(@Param("username") String username, @Param("address") String address);


}
