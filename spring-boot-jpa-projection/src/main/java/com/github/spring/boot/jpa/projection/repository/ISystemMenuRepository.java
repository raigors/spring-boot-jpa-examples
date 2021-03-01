package com.github.spring.boot.jpa.projection.repository;

import com.github.spring.boot.jpa.projection.pojo.orm.SystemMenuDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 用户信息增删改查接口
 * <p>
 * create in 2021/2/23 5:38 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface ISystemMenuRepository extends JpaRepository<SystemMenuDO, Long> {

    <T> List<T> findAllByParentMenuIdIsNull(Class<T> tClass);
}
