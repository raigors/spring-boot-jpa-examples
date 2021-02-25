package com.github.spring.boot.jpa.projection.pojo.vo;

import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

/**
 * TODO
 * <p>
 * create in 2021/2/24 5:20 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

public interface ISimpleUserInfoVO extends Serializable {

    @Value("#{@usernameMapper.getUsername(target.username)}")
    String getUsername();

    String getEmail();

}
