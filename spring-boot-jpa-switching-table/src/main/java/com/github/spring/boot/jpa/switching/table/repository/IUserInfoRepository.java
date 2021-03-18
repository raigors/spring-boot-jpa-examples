package com.github.spring.boot.jpa.switching.table.repository;

import com.github.spring.boot.jpa.switching.table.pojo.orm.UserInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户信息增删改查接口
 * <p>
 * create in 2021/2/23 5:38 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IUserInfoRepository extends JpaRepository<UserInfoDO, Long> {
}
