package com.github.spring.boot.jpa.projection.pojo.mapper;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * TODO
 * <p>
 * create in 2021/2/24 5:30 下午
 *
 * @author shishaodong
 * @version 0.0.1
 */

@Component
public class UsernameMapper {

    public String getUsername(String username) {
        return username + " - " + new Date().toString();
    }

}

