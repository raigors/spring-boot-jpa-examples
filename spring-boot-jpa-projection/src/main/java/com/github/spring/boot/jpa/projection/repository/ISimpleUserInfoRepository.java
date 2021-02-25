package com.github.spring.boot.jpa.projection.repository;

import com.github.spring.boot.jpa.projection.pojo.orm.SimpleUserInfoDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户信息增删改查接口
 * <p>
 * create in 2021/2/23 5:38 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface ISimpleUserInfoRepository extends JpaRepository<SimpleUserInfoDO, Long> {

    /**
     * 分页查询所有的UserInfoDO，并将字段投影到泛型 T 的字段上
     *
     * @param pageable 分页信息
     * @param clz      泛型类型
     * @param <T>      泛型
     * @return Page
     */
    <T> Page<T> findAllBy(Pageable pageable, Class<T> clz);

}
