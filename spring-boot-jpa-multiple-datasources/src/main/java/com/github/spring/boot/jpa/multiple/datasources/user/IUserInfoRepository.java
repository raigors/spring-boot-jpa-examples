package com.github.spring.boot.jpa.multiple.datasources.user;

import org.springframework.data.repository.CrudRepository;

/**
 * TODO
 * <p>
 * create in 2021/4/21 3:53 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface IUserInfoRepository extends CrudRepository<UserInfoDO, Long> {
}
