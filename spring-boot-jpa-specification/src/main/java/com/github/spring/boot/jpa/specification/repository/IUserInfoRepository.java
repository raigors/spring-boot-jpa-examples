package com.github.spring.boot.jpa.specification.repository;

import com.github.spring.boot.jpa.specification.pojo.orm.UserInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 用户信息增删改查接口
 * <p>
 * create in 2021/2/23 5:38 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IUserInfoRepository extends JpaRepository<UserInfoDO, Long>, JpaSpecificationExecutor<UserInfoDO> {
}
