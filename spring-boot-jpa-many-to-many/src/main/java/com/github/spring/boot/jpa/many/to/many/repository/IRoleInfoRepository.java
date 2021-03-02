package com.github.spring.boot.jpa.many.to.many.repository;


import com.github.spring.boot.jpa.many.to.many.pojo.orm.RoleInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户信息增删改查接口
 * <p>
 * create in 2021/2/23 5:38 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IRoleInfoRepository extends JpaRepository<RoleInfoDO, Long> {
}
